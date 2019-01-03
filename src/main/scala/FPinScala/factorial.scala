object factorial {
  val n = 5

  def fib(n: Int): Int = {
    def looper(n: Int, previously: Int, currently: Int): Int = {
      if (n == 0) previously
      else
        looper(n - 1, currently, previously + currently)
    }

    looper(n, 0, 1)
  }

  println(fib(n))
}