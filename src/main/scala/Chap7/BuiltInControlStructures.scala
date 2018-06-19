package Chap7

import java.io.File

class BuiltInControlStructures {
  // If Expressions
  // vals are perfered as it supports better equational reasoning and easier to refactor
  def varIf(args: Array[String]): Unit = {
    var filename = "default.txt"
    if (!args.isEmpty) filename = args(0)
  }

  def valIf(args: Array[String]): Unit = {
    println(if (!args.isEmpty) args(0) else "default.txt")
  }

  //  While Loops
  //  while and do while loops return type is Unit ()
  //  Calculating the greatest common divisor using loops
  //  using while loops like a java man
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  //  using do while untill empty line is entered
  def lineReaderTillEmptyLine(): Boolean = {
    var line = ""
    do {
      line = scala.io.StdIn.readLine()
      println("Read: " + line)
    } while (line != "")
  }

  // loop using recursion doesn't use vars
  def gcd(x: Long, y: Long): Long = if (y == 0) x else gcd(y, x % y)

  //  For loops are used in scala for iterations
  //  Iterations through collections

  def iterator() = {
    val filesHere = (new File(".")).listFiles
    for (file <- filesHere) // This is called a generator
      println(file)
  }

  for (i <- 1 to 5) println("Iternation " + i) // this prints 1 to 5
  for (i <- 1 until 5) println("Iternation " + i) // this doesn't print 5

  val someFileHere = List(1, 2, 3, 4, 5)
  for (i <- 0 to someFileHere.length - 1) println(someFileHere(i)) // the non-scala way
  for (i <- someFileHere.indices) println(someFileHere(i)) // The scala way

  //  Filtering
  //  allows iterations through selected parts of the collection

  def filtering() = {
    val filesHere: Array[File] = new java.io.File(".").listFiles()
    for (file <- filesHere if file.getName.endsWith(".scala")) println(file)
  }

  def betterFiltering(filesHere: Array[File] = new java.io.File(".").listFiles) = {
    for (file <- filesHere) if (file.getName.endsWith(".scala")) println(file)
  }

  def multipleForFilters(filesHere: Array[File] = new java.io.File(".").listFiles) = {
    for (
      file <- filesHere
      if file.isFile
      if file.getName.endsWith(".scala")
    ) println(file)
  }

  //  Nested iteration
  val filesHere = new java.io.File(".").listFiles

  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala"); // if this was inside {} there would be no need for ;
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

  grep(".*gcd.*")

  // Mid-stream variable binding
  def grepBetter(pattern: String) =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)

  grepBetter(".*gcd.*")

  // Producing a new collection
  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file // this results in a Array[File] inside a single collection
  // Transforming an Array[File] to a Array[Int] with for
  val forLineLengths =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(File)
    trimmed = line.trim
    trimmed.matches(".*for.*")
    if trimmed.matches(".*for.*")
  } yield trimmed.length

  // Exception handling with try expressions
  // exceptions can be thrown with `throw new IllegalArgumentException`
  // first an exception object is created the you throw it

  // Catching exception
  def catchThatException(): Unit = {
    import java.io.{FileNotFoundException, FileReader, IOException}

    try {
      val f = new FileReader("input.txt")
      //            do something with the file inputted
    } catch {
      case ex: FileNotFoundException => println("file cannot be found " + ex.getMessage) // Handle missing file
      case ex: IOException => println("Some other I/O Error " + ex.getMessage) // Handle other I/O Error
      case e => throw new Exception(e.getMessage)
    }
  }

  //  The finally Clause
  def finallyClauseThatException(): Unit = {
    import java.io.FileReader
    val file = new FileReader("input.txt")
    try {
      //      do something with the file inputted
    } finally {
      file.close() // Be sure to close the file after.
    }
  }

  //  Yielding a value
  def yealdingAValue(): Unit = {
    import java.net.{MalformedURLException, URL}
    def urlFor(path: String) =
      try {
        new URL(path)
      } catch {
        case e: MalformedURLException =>
          new URL("http://www.scala-lang.org")
      }
  }

  //  Match Expressions with side effects
  def matchEpressions(args: Array[String]): Unit = {
    val firstArg = if (args.length > 0) args(0) else ""
    firstArg match {
      case "salt" => println("pepper")
      case "hot" => println("cold")
      case "yes" => println("no")
      case "no" => println("yes")
      case _ => "what"
    }
  }

  //   A Match expression that yields a value
  def matchExpressionYield(args: Array[String]): Unit = {
    val firstArg = if (!args.isEmpty) args(0) else ""
    val friedFood =
      firstArg match {
        case "iceCream" => "applePie"
        case "potato" => "corn"
        case "eggs" => "bacon"
      }
    println(friedFood)
  }

  //  Not using Break and Continue

  def javaStyleBreakAndContinueInScala(args: Array[String]): Unit = {
    var i = 0
    var foundIt = false
    while (i < args.length & !foundIt) {
      if (!args(i).startsWith("-")) {
        if (args(i).endsWith(".scala"))
          foundIt = true
      }
      i = i + 1
    }
  }

  def recusiveAlternativeToLoopingWithVars(args: Array[String]): Unit = {
    def searchFrom(i: Int): Int =
      if (i >= args.length) -1
      else if (args(i).startsWith("-")) searchFrom(i + 1)
      else if (args(i).endsWith(".scala")) i
      else searchFrom(i + 1)

    val i = searchFrom(0)
  }

  def usingBreaksInScala(args: Array[String]): Unit = {
    import java.io._

    import scala.util.control.Breaks._
    val in = new BufferedReader(new InputStreamReader(System.in))
    breakable {
      while (true) {
        println("? ")
        if (in.readLine() == "") break()
      }
    }
  }

  //  Variable Scopes
  def printMultiplicationTable(): Unit = {
    var i = 1
    // Only i in the scope here
    while (i <= 10) {
      var j = 1
      // Both i and j in the scope here
      while (j <= 10) {
        val prod = (i * j).toString
        // i,j and prod in the scope here
        var k = prod.length
        // i,j, prod and k in the scope here
        while (k < 4) {
          print(" ")
          k += 1
        }
        println(prod)
        j += 1
      }
      // prod and k no longer in scope but i and j still in scope
      println()
      i += 1
    }
    //    only i is still in scope
  }

  def valChangeInnerScope(): Unit = {
    val a = 1;
    {
      // a is 1
      val a = 2
      // a is now 2
      println(a)
    }
    println(a)
  }

  //  Refactoring Imperative style code
  //  imperitive style is using loops and vars
  //  functional style is using for expressions and helper functions like .mkString
  def multiplicationTableRefactored: Unit = {
    def makeRowSeq(row: Int) =
      for (col <- 1 to 10) yield {
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
      }

    //  We factor out these two helper functions makeRow and multiTable
    def makeRow(row: Int) = makeRowSeq(row).mkString // Returns row as a string
    def multiTable = { // Returns table as a string with a row per line
      val tableSeq = // a sequence of rows
        for (row <- 1 to 10)
          yield makeRow(row)
      tableSeq.mkString("\n")
    }
  }
}
