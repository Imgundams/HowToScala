// #1 last element in a list
println("#1 last element in a list")

def last[A](list: List[A]):A = list match {
    case h :: Nil => h
    case _ :: tail => last(tail)
    case _ => throw new Exception
  }

println(last(List(1,2,3,4,5,6,7,8)))

// #2 last but 1 element in a list
println("#2 last but 1 element in a list")

def penultimate[A](list: List[A]):A = list match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimate(tail)
    case _ => throw new Exception
  }

println(penultimate(List(1,2,3,4,5,6,7,8)))

// #3 nth element in a list
println("#3 nth element in a list")

def nth[A](element : Int,list: List[A]):A =
  if (element >= 0) list(element)
else throw new NoSuchElementException


def nthRe[A](n: Int, list: List[A]): A = (n, list) match {
    case (0, h :: _   ) => h //First element (index 0) also pointed to by line below
    case (n, _ :: tail) => nthRe(n - 1, tail)
    case (_, Nil      ) => throw new NoSuchElementException
  }

println(nth(2, List(1,2,3,4,5,6,7,8))+" and "+nthRe(2, List(1,2,3,4,5,6,7,8)) + " Should be 3")

// #4 length of a list
println("#4 length of a list")
def length[A](list: List[A]):Int = {
  def looper[A](list: List[A], tempLength: Int): Int = {
    list match {
      case _ :: Nil => tempLength+1
      case _ :: tail => looper(tail, tempLength + 1)
      case _ => throw new Exception
    }
  }
    looper(list, 0)
}

println(length(List(1,2,3,4,5,6,7,8))+ " Should be " + List(1,2,3,4,5,6,7,8).length)

// #5 Reverse a list
println("#5 Reverse a list")

def reverse[A](list: List[A]):List[A]= {
  def looper[A](list: List[A], listB:List[A]): List[A] = listB match {
    case Nil => list //End of list
    case h :: tail => looper(h :: list , tail)
    case _ => throw new Exception
  }
  looper(Nil, list)
}
println(reverse(List(1,1,2,3,5,8))+ " Should be "+ List(1,1,2,3,5,8).reverse)

// #6 Find of if a list is Palindrome
println("#6 Find of if a list is Palindrome")

def isPalindrome[A](list: List[A]):Boolean = {
  def reverse[A](list: List[A]): List[A] = {
    def looper[A](list: List[A], listB: List[A]): List[A] = listB match {
      case Nil => list //End of list
      case h :: tail => looper(h :: list, tail)
      case _ => throw new Exception
    }
    looper(Nil, list)
  }
  reverse(list)==list
}

println(isPalindrome(List(1,1,2,3,5,3,2,1,1)) + " Should be true")


// #7 Flatten a list
println("#7 Flatten a list")

def flatten(list: List[Any]):List[Any] = list flatMap {
    case one: List[_] => flatten(one)
    case everthingElse => List(everthingElse)
}
println(flatten(List(List(1,1),2,List(3,List(5,8))))+ " Should be "+ List(1,1,2,3,5,8))
