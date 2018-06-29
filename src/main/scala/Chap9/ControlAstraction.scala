package Chap9

import java.io.{File, PrintWriter}

class ControlAstraction {

  // Reducing code duplication
  object FileMatcherOriginal {
    private def filesHere = (new File(".")).listFiles

    def filesEnding(query: String) =
      for (file <- filesHere
           if file.getName.endsWith(query)
      ) yield file

    def filesContaining(query: String) =
      for (file <- filesHere
           if file.getName.contains(query)
      ) yield file

    def filesRegex(query: String) =
      for (file <- filesHere
           if file.getName.matches(query)
      ) yield file
  }

  object FileMatcherOptimised {
    private def filesHere = (new File(".")).listFiles

    private def filesMatching(query: String, matcher: (String, String) => Boolean) = {
      for (file <- filesHere
           if (file.getName, query)
      ) yield file
    }

    def filesEnding(query: String) =
      filesMatching(query, _.endsWith(_))

    def filesContaining(query: String) =
      filesMatching(query, _.contains(_))

    def filesRegex(query: String) =
      filesMatching(query, _.matches(_))

    //    The function literal _.endsWith(_) means the same thing as
    //    (fileName:String, query: String) => fileName.endsWith(query)
  }

  object FileMatcherRefactoredOptimised {
    private def filesHere = (new File(".")).listFiles

    private def filesMatching(matcher: String => Boolean) = {
      for (file <- filesHere
           if matcher(file.getName)
      ) yield file
    }

    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))

    def filesContaining(query: String) =
      filesMatching(_.contains(query))

    def filesRegex(query: String) =
      filesMatching(_.matches(query))
  }

  //  Simplifiying Client Code
  // Its important to use high-order functions to reduce code duplication
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num < 0)
        exists = true
    exists
  }

  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num % 2 == 1)
        exists = true
    exists
  }

  def containsNegRefactored(nums: List[Int]) = nums.exists(_ < 0)

  def containsOddRefactored(nums: List[Int]) = nums.exists(_ % 2 == 1)

  //currying
  def plainOldSum(x: Int, y: Int) = x + y

  def curriedSum(x: Int)(y: Int) = x + y

  def first(x: Int) = (y: Int) => x + y

  val second = first(1)
  val onePlus = curriedSum(1) _
  onePlus(2) // Int = 3
  val twoPlus = curriedSum(2) _
  twoPlus(2) // Int = 4

  //Writing new control structures,

  def twice(op: Double => Double, x: Double) = op(op(x))

  twice(_ + 1, 5)

  def withPrintWriter1(file: File, op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close
    }
  }

  withPrintWriter1(
    new File("date.txt"),
    writer => writer.println(new java.util.Date)
  )

  println("Hello, World!")
  println {
    "Hello, World!"
  } // {} only works if passing one argument
  val g = "Hello, World!"
  //  g.substring{5, 7} //
  g.substring(7, 9)

  def withPrintWriter2(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  val file = new File("date.txt")
  withPrintWriter2(file) { writer => writer.println(new java.util.Date)
  }

  // By-name Parameters

  withPrintWriter2(file) { writer =>
    writer.println(new java.util.Date)
  }
  var assertionsEnabled = true

  def myAssert(predicate: () => Boolean) =
    if (assertionsEnabled && !predicate())
      throw new AssertionError

  myAssert(() => 5 > 3)

  // to make the assert to better so it's like myAssert(5 > 3) we use the By-name Parameters
  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  byNameAssert(5 > 3)

  def boolAssert(predicate: Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  boolAssert(5 > 3)

  val x = 5
  var assertionEnabled = false
  //  boolAssert(x/ 0 == 0) //Cant divide by zero
  byNameAssert(x / 0 == 0)

}
