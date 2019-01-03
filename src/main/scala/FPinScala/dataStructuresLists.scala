
sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))


  val x = List(1, 2, 3, 4, 5) match {
    case Cons(h, t) => h
    case _ => 42
  }

  def sum(ints: List[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
    case Nil => 0 // The sum of the empty list is 0.
    case Cons(x, xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def append[A](list1: List[A], list2: List[A]): List[A] =
    list1 match {
      case Nil => list2
      case Cons(heads, tails) => Cons(heads, append(tails, list2))
    }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = {
    l match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x, y) => x + y)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar

  // Exercise 1
  val exercise1 = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => (x + y)
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }

  // Exercise 2
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => l
    case Cons(_, Nil) => Nil
    case Cons(_, tails) => tails
  }


  // Exercise 3
  def drop[A](l: List[A], dropTillThisValue: Int): List[A] = dropTillThisValue match {
    case 0 => l
    case _ if dropTillThisValue < 0 => drop(tail(l), -dropTillThisValue - 1)
    case _ => drop(tail(l), dropTillThisValue - 1)
  }

  // Exercise 4
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = {
    l match {
      case Nil => Nil
      case Cons(heads, tails) => f(heads) match {
        case true => dropWhile(tails)(f)
        case false => tails
      }
    }
  }

  // Exercise 5
  def setHead[A](l: List[A], heads: A): List[A] = Cons(heads, tail(l))

  // Exercise 6
  def init[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(_, Nil) => Nil
      case Cons(heads, tails) => Cons(heads, init(tails))
    }
  }

  def length[A](l: List[A]): Int = {
    def looper(list: List[A], counter: Int): Int = {
      list match {
        case Nil => counter
        case Cons(_, Nil) => counter + 1
        case Cons(heads, tails) => looper(tails, counter + 1)
      }
    }

    looper(l, 0)
  }


  // Exercise 9
  def length2[A](l: List[A]): Int = foldRight(l, 0)((a, b) => b + 1)

  // Exercise 11
  def sum3(l: List[Int]): Int = foldLeft(l, 0)(_ + _)

  def product3(l: List[Int]): Int = foldLeft(l, 0)(_ * _)

  // Exercise 12
  def reverse2[A](list: List[A]): List[A] = foldLeft(list, List[A]())((resultList, head) => Cons(head, resultList))

  def p(somethingToPrint: Any): Unit = println(somethingToPrint)

  // Exercise 13
  def foldLeftWithFoldRight[A, B](list: List[A], z: B): List[A] = ???


  def map[A, B](l: List[A])(f: A => B): List[B] = ???

  val nullList = Nil

  val list1Nil = Cons(1, Nil)

  val list1 = Cons(1, Cons(2, Nil))

  val list2 = Cons(1, Cons(5, Cons(55, Nil)))

  val list3 = Cons(11, Cons(22, Cons(33, Cons(44, Cons(55, Cons(66, Cons(77, Nil)))))))

  tail(list2)

  drop(list3, 3)
  drop(list3, -2)
  setHead(list3, 5555)
  dropWhile(list3)(x => x < 33)
  init(list3)
  p(length(list3))
  p(length2(list3))
  p(reverse2(list3))
}