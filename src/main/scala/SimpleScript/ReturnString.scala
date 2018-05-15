//ScalaCookBook

// 1.2. Multiline String
val multiCodeLineString=
  """Line1
Line2
Line3
Line4"""
val multiLineString =
  """Line 1
    |Line 2
    |Line 3
  """.stripMargin//here replaces
println(s"Here is a multi-line code String \n$multiCodeLineString")
println(s"Here is a multi-line String \n$multiLineString")

// 1.3. Spliting String
val commaSeparatedValues = "one, two, three, four, five"
commaSeparatedValues.split(",")//becomes an Array type

// 1.4. Subtituting variables into Strings
val name = "Dan"
val age = 100
val weight = 100.1
println(s"$name is $age year${if(age>0)""else "s"} old," +
  s" and weighs $weight kilogram${if(weight==1||weight==0)""else "s"}.")// {} allows expressions inside
case class Person(name:String,age:Int,weight:Double)
val dan:Person = Person(name,age,weight)
println(s"${dan.name} is ${dan.age} and all the data is $dan")
println(f"${dan.weight}%.2f")

// 1.5. processing strings one at a time
def upper(input:String):String ={input.map(_.toUpper)}
val uppercaseString:String = upper("hellohellos")
println(uppercaseString.filter(_!='L').replace('O','L'))

// 1.6. Finding Pattern in Strings
val numPattern = "[0-9]+".r
val addressToRegex = "1234 Super Long Avenue 10101"
numPattern.findAllIn(addressToRegex).foreach(println)

// 1.7. Replacing Patterns in Strings
val addressNoNumbersReg = numPattern.replaceAllIn(addressToRegex,"No")
val addressNoNumbers = addressToRegex.replaceAll("[0-9]","x")
println(addressNoNumbers+ "\n"+  addressNoNumbersReg)

// 1.8. Extracting Parts of a String That Match Patterns
val pattern = "([0-9]+) ([A-Za-z]+)".r
val pattern(count, fruit) = "100 Bananas"
println(count+" "+fruit)

// 1.9.Accessing a Character in a String
val characterInAString="CharacterInAString"
println(characterInAString(2)+""+characterInAString(1))

// 1.10. Add Your Own Methods to the String Class
implicit class StringImprovements(s:String){
  def increment = s.map(c => (c + 1).toChar)
  def decrement = s.map(c => (c - 1).toChar)
  def randomise = s.map(_=> scala.util.Random.nextInt.toChar)
}
println(characterInAString.increment)
println(characterInAString.randomise)