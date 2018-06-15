package Chap7

import java.io.File

class BuiltInControlStructures {
  // If Expressions
  // vals are perfered as it supports better equational reasoning and easier to refactor
  {
    //    var filename = "default.txt"
    //    if (!args.isEmpty) filename = args(0)
  }
  {
    //    println(if (!args.isEmpty) args (0) else "default.txt")
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
    import java.io.FileReader
    import java.io.FileNotFoundException
    import java.io.IOException

    try {
      val f = new FileReader("input.txt") // Use and close file
    } catch {
      case ex: FileNotFoundException => // Handle missing file
      case ex: IOException => // Handle other I/O error
      case e => throw new Exception(e.getMessage)
    }
  }
}