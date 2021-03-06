//Step 7
object chapter3 {
  val greetStrings = new Array[String](3)

  greetStrings(0) = "Hello"
  greetStrings(1) = ", "
  greetStrings(2) = "World!\n"

  for (i <- 0 to 2)
    print(greetStrings(i))
  // using foreach
  // greetStrings.foreach(print(_))
  val numNames = Array("zero", "one", "two")
  numNames.update(1, "ONE")
  print("numNames")
  numNames.foreach(x => println(x))

  val newNumNames = List("zero", "one", "two")
  val lol: String = "lol"
  print("newNumNames")
  (lol :: newNumNames.reverse).reverse.foreach(x => println(x))

  // Step 8 use lists
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour
  println(oneTwo + " and " + threeFour + " were not mutated.")
  println("Thus, " + oneTwoThreeFour + " is a new list.")

  val twoThree = List(2, 3)
  val oneTwoThree = 1 :: twoThree
  println(oneTwoThree)

  // Step 9 Use Tuples

  val pair = (99, "Balloons")
  println(pair._1)
  println(pair._2)

  // Step 10 Use Sets and Maps
  var jetSet = Set("Boeing", "Airbus", "Lear")
  jetSet += "Radio"
  println(jetSet.contains("Radio"))

  val thoseWhoLiveUnderTheSea = scala.collection.mutable.Set("SpongeBob", "Nimo")
  thoseWhoLiveUnderTheSea += "Patrick Star"
  println(thoseWhoLiveUnderTheSea)

  val treasureMap = Map[Int, String](
    1 -> "Sail the Seas",
    2 -> "Dive to Atlantis",
    3 -> "Slay the Kraken",
    4 -> "Go Home"
  )
  println(treasureMap(3))

  // Step 11 Recognising the Fun style

  def printArgs(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  def formatArgs(args: Array[String]) = {
    args.mkString("\n")
  }

  println(formatArgs(Array("a", "a", "a")))

}

object ReadLines {

  val args = Array("hello", "You", "!")

  // Step 12 Read lines from a file
  class ReadLines(a: Any) {

    import scala.io.Source

    if (args.length > 0) {
      for (line <- Source.fromFile(args(0)).getLines())
        println(s"${line.length} $line")
    }
    else
      Console.err.println("Please enter a filename")

    val lines = Source.fromFile(args(0)).getLines().toList

    def widthOfLength(s: String) = s.length.toString.length

    val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
    val maxWidth = widthOfLength(longestLine)
    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length + " | " + line)
    }
  }

}
