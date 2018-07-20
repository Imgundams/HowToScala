package Chap12

class Traits {
  trait PrintLiner {
    def printLiner() = {
      println("Consuming memory.")
    }
  }
  class Ant extends PrintLiner {
    override def toString: String = "Ant!"
  }
//  by calling Bug.printLiner we use the printLiner Method in the trait

  class Bug

  class Wasp extends Bug with PrintLiner{
    override def toString: String = "Wasp!"
  }

  class Bee extends Bug with PrintLiner {
    override def toString: String = "Bzzzz!"
    override def printLiner(): Unit = {println(toString +" Eating Memory")}
  }

// Rich Vs Thin Interfaces
  trait CharSequences {
  def charAt(index: Int): Char
  def length : Int
  def subSequences(start: Int, end : Int):CharSequences
  def toString(): String
  }
// To enrich a Interface using traits you define abstract methods in the trait.

  class Point (val x: Int, val y: Int)
  class Rectangle(val topLeft: Point, val bottomRight: Point){
    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
  }
  abstract class Component{
    def topLeft: Point
    def bottomRight: Point
    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
  }

  trait Rectangular {
    def topLeft: Point
    def bottomRight: Point
    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
  }
  abstract class Components extends Rectangular //This gets us all the methods in rectangular

  class RectangleWithExtends(val topLeft: Point, val bottomRight: Point)
    extends Rectangular {
    ???
  }

  // Ordered Trait
  class Rational(n: Int, d: Int){
    def < (that: Rational) =
      this.n * that.d < that.n * this.d
    def > (that: Rational) = that < this
    def <= (that: Rational) = (this < that) || (this == that)
    def >= (that: Rational) = (this > that) || (this == that)
  }

}
