//ScalaCookBook
object  ReturnString {
  // 1.2. Multiline String
  val multiCodeLineString =
    """Line1
Line2
Line3
Line4"""
  val multiLineString =
    """Line 1
      |Line 2
      |Line 3
    """.stripMargin //here replaces
  println(s"Here is a multi-line code String \n$multiCodeLineString" + s"Here is a multi-line String \n$multiLineString")

  // 1.3. Spliting String
  val commaSeparatedValues = "one, two, three, four, five"
  commaSeparatedValues.split(",") //becomes an Array type

  // 1.4. Subtituting variables into Strings
  val name = "Dan"
  val age = 100
  val weight = 100.1
  println(s"$name is $age year${if (age > 0) "" else "s"} old," + s" and weighs $weight kilogram${if (weight == 1 || weight == 0) "" else "s"}.")

  // {} allows expressions inside
  case class Person(name: String, age: Int, weight: Double)

  val dan: Person = Person(name, age, weight)
  println(s"${dan.name} is ${dan.age} and all the data is $dan" + f"${dan.weight}%.2f")

  // 1.5. processing strings one at a time
  def upper(input: String): String = {
    input.map(_.toUpper)
  }

  val uppercaseString: String = upper("hellohellos")
  println(uppercaseString.filter(_ != 'L').replace('O', 'L'))

  // 1.6. Finding Pattern in Strings
  val numPattern = "[0-9]+".r
  val addressToRegex = "1234 Super Long Avenue 10101"
  numPattern.findAllIn(addressToRegex).foreach(println)

  // 1.7. Replacing Patterns in Strings
  val addressNoNumbersReg = numPattern.replaceAllIn(addressToRegex, "No")
  val addressNoNumbers = addressToRegex.replaceAll("[0-9]", "x")
  println(addressNoNumbers + "\n" + addressNoNumbersReg)

  // 1.8. Extracting Parts of a String That Match Patterns
  val pattern = "([0-9]+) ([A-Za-z]+)".r
  val pattern(count, fruit) = "100 Bananas"
  println(count + " " + fruit)

  // 1.9.Accessing a Character in a String
  val characterInAString = "CharacterInAString"
  println(characterInAString(2) + "" + characterInAString(1))

  // 1.10. Add Your Own Methods to the String Class
  implicit class StringImprovements(s: String) {
    def increment = s.map(c => (c + 1).toChar)

    def decrement = s.map(c => (c - 1).toChar)

    def randomise = s.map(_ => scala.util.Random.nextInt.toChar)

    def randomiseLetter = s.map(_ => scala.util.Random.nextPrintableChar())
  }

  println(characterInAString.increment + "\n" + characterInAString.randomise + "\n" + characterInAString.randomiseLetter)

  // 2.1. Parsing a Number from a String
  val oneHundred = "100"
  println(oneHundred.toInt + 1 + "\n" + oneHundred.toDouble + 0.00001)

  def toInt(string: Option[String]): Option[Int] = {
    try {
      string match {
        case Some(n) => Some(n.toInt)
        case _ => None
      }
    } catch {
      case e: NumberFormatException => None
    }
  }

  println(toInt(Some(" ")))

  // 2.2. Converting Between Numeric Types (Casting)
  println(19.55.toInt + 18.98.toInt)

  // 2.3. Overriding the Default Numeric Type
  val double = 1d
  val twentyInHexAsLong = 0x20L

  // 2.4. Replacements for ++ and −−
  var variable = 1
  variable += 1

  // 2.5. Comparing Floating-Point Numbers
  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }

  println(~=(0.6, 0.601, 0.001))

  // 2.6. Handling Very Large Numbers
  println(s"Byte.MaxValue:${Byte.MaxValue}\nShort.MaxValue:${Short.MaxValue}\nInt.MaxValue:${Int.MaxValue}\nLong.MaxValue:${Long.MaxValue}\nDouble.MaxValue:${Double.MaxValue}")

  // 2.7. Generating Random Numbers
  val r = new scala.util.Random
  println(f"${r.nextGaussian()}%1.2f\nHere are random Vectors:${for (i <- 1 to 5) yield r.nextInt(100)}")

  // 2.8. Creating a Range, List, or Array of Numbers
  val rangeOfArray = 1 to 10 toArray
  val rangeOfList = 1 to 10 toList
  val rangeOfNumbers = 1 to 10
  val rangeOfEvenNumbers = for (i <- 1 to 10) yield i * 2

  // 2.9. Formatting Numbers and Currency
  val pi = scala.math.Pi
  println(f"£$pi%1.2f")

  // 3.1. Looping with for and foreach
  val fruitBasket = Array("apple", "banana", "orange", "apple", "apple")
  val names = Map("firstName" -> "Daniel",
    "lastName" -> "Rain",
    "age" -> 100,
    "weight" -> 10.1)
  for ((aaa, bbb) <- names) println(s"key: $aaa, value: $bbb")

  // 3.2. Using for Loops with Multiple Counters
  val arrayDim = Array.ofDim[Int](2, 2)
  arrayDim(0)(0) = 0
  arrayDim(0)(1) = 1
  arrayDim(1)(0) = 2
  arrayDim(1)(1) = 3

  // 3.3. Using a for Loop with Embedded if Statements
  for {
    i <- 1 to 20
    if i % 10 == 0
    if i > 15
  } println(i)

  // 3.4. Creating a for Comprehension (for/yield Combination)
  val firstNames = Array("chris", "ed", "maurice")
  val capNames = for (e <- firstNames) yield println(e.capitalize)

  // 3.5. Implementing break and continue ((SKIPPING BECAUSE REASONS))

  // 3.6. Using the if Construct Like a Ternary Operator
  def abs(x: Int) = if (x >= 0) x else -x

  def max(a: Int, b: Int) = if (a > b) a else b

  // 3.7. Using a Match Expression Like a switch Statement
  val monthNumber = 5
  val month =
    monthNumber match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case 4 => "April"
      case 5 => "May"
      case 6 => "June"
      case 7 => "July"
      case 8 => "August"
      case 9 => "September"
      case 10 => "October"
      case 11 => "November"
      case 12 => "December"
      case _ => "Undecimber"
    }

  // 3.8
}