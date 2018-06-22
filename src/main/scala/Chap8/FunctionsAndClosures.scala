package Chap8

class FunctionsAndClosures {

  //  Methods
  class longLinesPrivateProcessLine {

    import scala.io.Source

    object LongLine {
      def processFile(filename: String, width: Int) = {
        val source = Source.fromFile(filename)
        for (line <- source.getLines())
          processLine(filename, width, line)
      }

      private def processLine(filename: String, width: Int, line: String) = {
        if (line.length > width)
          println(filename + ": " + line.trim)
      }
    }

    object FindLongLines {
      def main(args: Array[String]): Unit = {
        val width = args(0).toInt
        for (arg <- args.drop(1))
          LongLine.processFile(arg, width)
      }
    }

  }

  //  Local Functions
  //  Principle of Functional programming is programs should
  // be able to be decomposed into small functions that do a
  //  well defined function well
  class LongLinesLocalProcessLine {

    import scala.io.Source

    object LongLines {
      def processFile(filename: String, width: Int): Unit = {
        def processLine(line: String): Unit = {
          if (line.length > width) println(filename + ": " + line.trim)
        }

        val source = Source.fromFile(filename)
        for (line <- source.getLines()) processLine(line)
      }
    }

  }

  // First-Class Functions

  // Function literals
  class FunctionLiterals {
    (x: Int) => x + 1
    var increase = (x: Int) => x + 1
    increase(49) // Returns 50
    increase = (x: Int) => x + 9999
    increase(101) // Returns 10100 because vars are mutable
    increase = (x: Int) => {
      println(x)
      println(" + 1 ")
      println("is ")
      x + 1
    }
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    someNumbers.filter((x: Int) => x > 0)
    val f = (_: Int) + (_: Int)
    f(50, 100)
  }

  // Partially applied functions

  class PartiallyAppliedFunctions {
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach(println _)
    someNumbers.foreach(x => println(x)) // Both this and above are treated the same by scala

    def sum(a: Int, b: Int, c: Int): Int = a + b + c

    val c = sum _ // treated as a partially applied function
    val d = sum _
    d(10, 20, 30)
  }

  // Closure
  class Closures {
    //  (x:Int) => x + more // more causes compilation error on it's own
    (x: Int) => x + _

    (x: Int) => x + more
    val more = 1
    val addMore = (x: Int) => x + more
    addMore(10)

    def makeIncreaser(more: Int) = (x: Int) => x + more

    val inc1 = makeIncreaser(1) // creates method where if inc1(Int) is used it will Int + 1
    val inc9999 = makeIncreaser(9999)
    inc1(9) // returns 10
    inc9999(1) // returns 10000
  }

  // Special Function Call Forms
  class SpecialFunctionCallForms {
    def echo(args: String*) =
      for (arg <- args) println(args)

    echo("gello", "hello")

    val arr = Array("What", "are", "birds?")
    arr: Array[String]
    //  echo(arr) // cannot compile sees it as a single enviroment
    echo(arr: _*)

    //  Named Arguments
    def speed(distance: Float, time: Float): Float =
      distance / time

    speed(100, 10)

    // Default Parameters
    def printTime(out: java.io.PrintStream = Console.out) = out.println("time = " + System.currentTimeMillis())

    def printTime2(out: java.io.PrintStream = Console.out, divison: Int = 1) = // use default value of division of 1
      out.println("time = " + System.currentTimeMillis() / divison)

    printTime2(divison = 1000) // default values can be changed like so
  }

  //  Tail Recursion
  class TailRecusion {

    def isGoodEnough(d: Double) = ???

    def improve(d: Double) = ???

    def approximate(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else approximate((improve(guess)))
    }

    def approximateLoop(initalGuess: Double): Double = {
      var guess = initalGuess
      while (isGoodEnough(guess))
        guess = improve(guess)
      guess
    }
  }

}
