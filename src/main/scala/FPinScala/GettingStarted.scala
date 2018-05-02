//Comment
import scala.util.Random
object MyModule {

  // Absolute
  def absolute(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  // Factorial
  def factorial(n: Int): Int = {
    def looper(n: Int, accumulator: Int): Int =
      if (n <= 0) accumulator
      else looper(n - 1, n * accumulator)

    looper(n, 1)
  }

  //  Fibonacci
  def fibonacci(n: Int): Int = {
    def looper(n: Int, previously: Int, currently: Int): Int = {
      if (n == 0) previously
      else
        looper(n - 1, currently, currently + previously)
    }

    looper(n, 0, 1)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, absolute(x))
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(absolute(x), factorial(absolute(x)))
  }

  private def formatFibonacci(x: Int) = {
    val msg = "The fibonacci of %d is %d"
    msg.format(absolute(x), fibonacci(absolute(x)))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  def main(arg: Array[String]): Unit = {
    println(formatAbs(arg.head.toInt)
      + "\n" +
      formatFactorial(arg.head.toInt)
      + "\n" +
      formatFibonacci(arg.head.toInt)
      + "\n" +
      formatResult("Absolute", arg.head.toInt, absolute)
      + "\n" +
      formatResult("Factorial", arg.head.toInt, factorial)
      + "\n" +
      formatResult("Fibonacci", arg.head.toInt, fibonacci))
    println(formatResult("absolute value", -42, absolute))
    println(formatResult("increment", 7, factorial))
    println(formatResult("increment", 7, (x: Int) => x + 1))
    println(formatResult("increment", 7, (x) => x + 1))
    println(formatResult("increment", 7, x => x + 1))
    println(formatResult("increment", 7, _ + 1))
    println(formatResult("increment", 7, x => {val r = x + 1;r}))
    TestFib

  }

  object TestFib {
    println("Expected: 0, 1, 1, 2, 3, 5, 8")
    println("Actual:   %d, %d, %d, %d, %d, %d, %d".format(
      fibonacci(0), fibonacci(1), fibonacci(2), fibonacci(3), fibonacci(4), fibonacci(5), fibonacci(6)))
  }

  // Monomorphic function (can only do one type)
  def binarySearch(ds: Array[Double], key: Double): Int = {
    //    @annotate.tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val d = ds(mid2)
        if (d == key) mid2
        else if (d > key) go(low, mid2, mid2 - 1)
        else go(mid2 + 1, mid2, high)
      }
    }

    go(0, 0, ds.length - 1)
  }

  // Polymorphic function (can do many types)
  def binarySearch[A](as: Array[A], key: A, gt: (A, A) => Boolean): Int = {
    @annotation.tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val a = as(mid2)
        val greater = gt(a, key)
        if (!greater && !gt(key, a)) mid2
        else if (greater) go(low, mid2, mid2 - 1)
        else go(mid2 + 1, mid2, high)
      }
    }
    go(0, 0, as.length - 1)
  }
}
