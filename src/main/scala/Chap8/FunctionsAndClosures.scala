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
  class longLinesLocalProcessLine {
    import scala.io.Source
    object LongLines {
      def processFile(filename: String, width: Int) :Unit= {
        def processLine(line: String) :Unit= {
          if (line.length > width) println(filename + ": " + line.trim)
        }
        val source = Source.fromFile(filename)
        for (line <- source.getLines()) processLine(line)
      }
    }
  }

  // First-Class Functions

  // Function literals
  (x:Int) => x+1
  var increase = (x: Int) => x+1
  increase(49)  // Returns 50
  increase = (x:Int) => x + 9999
  increase(101) // Returns 10100 because vars are mutable
  increase = (x:Int) => {
    println(x)
    println(" + 1 ")
    println("is ")
    x + 1
  }
  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  someNumbers.foreach((x: Int) => println(x))
  someNumbers.filter((x: Int) => x > 0)
}
