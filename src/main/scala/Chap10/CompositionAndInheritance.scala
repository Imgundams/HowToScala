package Chap10

class CompositionAndInheritance {

  // We create a library here

  object TwoDLayoutLibrary {

    //   def elem(s:String) : Element

    //    val column1 = elem("hello") above elem("***")
    //    val column2 = elem("***") above elem("world")
    //    column1 beside column2
  }

  abstract class Element1 {
    def contents: Array[String]
  }

  // Defining Parameterless Methods
  // parameterless methods are methods without ()
  abstract class Element2 {
    def contents: Array[String] // these def require extra memory in each Element object
    def height: Int = contents.length // these are called empty-paraen methods
    def width: Int = if (height == 0) 0 else contents(0).length
  }

  // implementing heigh and width as fields
  abstract class Element3 {
    def contents: Array[String]

    val height: Int = contents.length // these vals are precomputed
    val width: Int =
      if (height == 0) 0 else contents(0).length
  }

  Array(1, 2, 3).toString
  "abc".length
  "hello".length // doesn't need () since no side effect
  println()

  // Extending Class
  class ArrayElement(conts: Array[String]) extends Element3 {
    def contents: Array[String] = conts
  }

  val ae = new ArrayElement(Array("hello world"))
  ae.width

  val e = new ArrayElement(Array("hello"))

  class ArrayElement2(conts: Array[String]) extends Element3 {
    //    def contents: Array[String] = conts
    val contents: Array[String] = conts
    // In scala you cannot define a field and method with the same name in the same class

  }

  // Defining parametric fields

  class ArrayElement3(
                       val contents: Array[String] // here the contents are described as paramentic fields
                     ) extends Element3

  class ArrayElement4(x123: Array[String]) extends Element3 {
    val contents: Array[String] = x123
  }

  class Cat {
    val dangerous = false
  }

  class Tiger(override val dangerous: Boolean,
              private var age: Int
             ) extends Cat

  // This is equivalent to the following class
  class TigerEquivalence(parameter1: Boolean, parameter2: Int) extends Cat {
    override val dangerous = parameter1
    private var age = parameter2
  }

  // Invoking Superclass Constructors
  class LineElement(s:String) extends

}
