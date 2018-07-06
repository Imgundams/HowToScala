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
  class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
  }

  val ae1 = new ArrayElement(Array("hello world"))
  ae.width

  val e = new ArrayElement(Array("hello"))

  class ArrayElement2(conts: Array[String]) extends Element2 {
    def contents: Array[String] = conts

    //    val contents: Array[String] = conts
    // In scala you cannot define a field and method with the same name in the same class

  }

  // Defining parametric fields

  class ArrayElement3(
                       val contents: Array[String] // here the contents are described as paramentic fields
                     ) extends Element2

  class ArrayElement4(x123: Array[String]) extends Element2 {
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
  class LineElement4(s: String) extends ArrayElement4(Array(s)) {
    override val height: Int = 1
    override val width: Int = s.length
  }

  // Using override modifiers

  //  def hidden():Boolean

  // Polymorphisim and Dynamic Binding

  class UniformElement(
                        ch: Char,
                        override val height: Int,
                        override val width: Int
                      ) extends Element2 {
    private val line = ch.toString * width

    def contents = Array.fill(height)(line)
  }

  val e1: Element2 = new ArrayElement4(Array("hello", "world"))
  val ae: ArrayElement4 = new LineElement4("hello")
  val e2: Element2 = ae

  //  val e3: Element3 = new UniformElement('x',2,3)

  abstract class ElementDemo {
    def demo() = {
      println("Element's implementation invoked")
    }
  }

//  class ArrayElement extends ElementDemo {
//    override def demo() = {
//      println("ArrayElement's implementation invoked")
//    }
//  }

//  class LineElement2 extends ArrayElement {
//    override def demo() = {
//      println("LineElement's implementation invoked")
//    }
//  }

  //UniformElement inherits ElementDemo
  class UniformElementDemo extends ElementDemo

  def invokeDemo(e: ElementDemo) = {
    e.demo()
  }

//  invokeDemo(new ArrayElement2)
//  invokeDemo(new LineElement2)
  invokeDemo(new UniformElementDemo) // does not override demo but inherits from super class ElementDemo

  // Declaring Final Memebers
  //  The following wont compile as it attempts to overwrite demo in its subclass LineElement
  //  class ArrayElement extends ElementDemo {
  //  final override def demo() = {
  //    println("ArrayElement's implementation invoked")
  //    }
  //  }

  //  Here is the class declared as final sp that any attempt at defining a subclass won't compile
  //  final class ArrayElement extends ElementDemo {
  //    override def demo() = {
  //    println("ArrayElement's implementation invoked")
  //    }
  //  }

  // Using Composition and Inheritance
  class LineElement(s: String) extends Element {
    def contents = Array(s)

    override def width: Int = s.length

    override def height: Int = 1
  }

  // Implementing the other parts of the element library

//  def above(that: Element): Element =
//    new ArrayElement(this.contents ++ that.contents)
//
//  def beside(that: Element): Element = {
//    val contents = new Array[String](this.contents.length)
//    for (i <- 0 until this.contents.length)
//      contents(i) = this.contents(i) + that.contents(1)
//    new ArrayElement(content)
//  }
//  new ArrayElement(for (
//    (line1, line2) <- this.contents zip that.contents
//  ) yield line1 + line2
//  )

  abstract class Element {
    def contents: Array[String]
    def width: Int =
      if (height == 0) 0 else contents(0).length
    def height: Int = contents.length
    def above(that: Element): Element =
      new ArrayElement(this.contents ++ that.contents)
    def beside(that: Element): Element =
      new ArrayElement(
        for (
          (line1, line2) <- this.contents zip that.contents
        ) yield line1 + line2
      )
    override def toString = contents mkString "\n"
  }
//  Defining a Factory Object
  object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = ???
//    new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)

  }
}
