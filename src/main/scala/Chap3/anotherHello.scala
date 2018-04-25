val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "World!\n"

for (i <- 0 to 2)
  print(greetStrings(i))
// using foreach
// greetStrings.foreach(print(_))
val numNames = Array("zero", "one", "two")
numNames.update(1,"ONE")
print("numNames")
numNames.foreach(x => println(x))

val newNumNames = List("zero", "one", "two")
val lol:String = "lol"
print("newNumNames")
(lol::newNumNames.reverse).reverse.foreach(x => println(x))
