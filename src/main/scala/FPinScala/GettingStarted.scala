//Comment
object GettingStarted {

  // Absolute
  def absolute(n:Int): Int = {
    if (n < 0) -n
    else n
  }

  // Factorial
  def factorial(n: Int): Int = {
    def looper(n:Int, accumulator:Int): Int =
      if (n <= 0) accumulator
      else looper(n-1, n*accumulator)
    looper(n,1)
  }

  //  Fibonacci
  def fibonacci(n:Int):Int = {
    def looper(n: Int, previously: Int, currently: Int): Int = {
      if (n == 0) previously
      else
        looper(n - 1, currently, currently + previously)
    }
    looper(n,0,1)
  }

  private def formatAbs (x:Int)= {
    val msg = "The absolute value of %d is %d"
    msg.format(x,absolute(x))
  }
  private def formatFactorial (x:Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(absolute(x), factorial(absolute(x)))
  }
  private def formatFibonacci (x:Int) = {
    val msg = "The fibonacci of %d is %d"
    msg.format(absolute(x), fibonacci(absolute(x)))
  }
  def formatResult(name:String, n: Int, f:Int => Int) ={
    val msg = "The %s of %d is %d."
    msg.format(name,n,f(n))
  }

  def main (arg: Array[String]):Unit ={
    val n :Int = arg.head.toInt
    println(  formatAbs(n)
      +"\n"+
              formatFactorial(n)
      +"\n"+
              formatFibonacci(n)
      +"\n"+
              formatResult("Absolute",n,absolute)
      +"\n"+
              formatResult("Factorial",n,factorial)
      +"\n"+
              formatResult("Fibonacci",n,fibonacci))
  }
}
