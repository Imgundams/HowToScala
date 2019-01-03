//package Chap6

// Constructing a Object
class Rational1(numerator: Int, denominator: Int) {
  println("Created " + numerator + "/" + denominator)
}

// Re-Implimenting the toString Method
class Rational2(numerator: Int, denominator: Int) {
  override def toString: String = numerator + "/" + denominator
}

// Added a precondition to the Object
class Rational3(numerator: Int, denominator: Int) {
  require(denominator != 0)

  override def toString: String = numerator + "/" + denominator
}

// Adding fields and Methods
class Rational4(numerator: Int, denominator: Int) {
  require(denominator != 0)

  override def toString: String = numerator + "/" + denominator

  def add(that: Rational4): Rational4 =
    new Rational4(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)

  // Self References
  def lessThen(that: Rational4) =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: Rational4) =
    if (this.lessThen(that)) that else this
}

//  Auxiliary Constructors

class Rational5(n: Int, d: Int) {

  require(d != 0)

  val numer: Int = n
  val denom: Int = d

  def this(n: Int) = this(n, 1) // auxiliary constructor

  override def toString = numer + "/" + denom

  def add(that: Rational5): Rational5 =
    new Rational5(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
}

// Private fields and methods
class Rational6(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def add(that: Rational6): Rational6 =
    new Rational6(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

// Defining Operators
class Rational7(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational7): Rational7 =
    new Rational7(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def *(that: Rational7): Rational7 =
    new Rational7(numer * that.numer, denom * that.denom)

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

// Identifiers in Scala - Literal Identifiers are arbirary Strings enclosed in back ticks ``

// Method Overloading
 class Rational8(n: Int, d: Int) {

 require(d != 0)

 private val g = gcd(n.abs, d.abs)
 val numer = n / g
 val denom = d / g

 def this(n: Int) = this(n, 1)

 def + (that: Rational8): Rational8 =
 new Rational8(
 numer * that.denom + that.numer * denom,
 denom * that.denom
 )

 def + (i: Int): Rational8 =
 new Rational8(numer + i * denom, denom)

 def - (that: Rational8): Rational8 =
 new Rational8(
 numer * that.denom - that.numer * denom,
 denom * that.denom
 )

 def - (i: Int): Rational8 =
 new Rational8(numer - i * denom, denom)

 def * (that: Rational8): Rational8 =
 new Rational8(numer * that.numer, denom * that.denom)

 def * (i: Int): Rational8 =
 new Rational8(numer * i, denom)

 def / (that: Rational8): Rational8 =
 new Rational8(numer * that.denom, denom * that.numer)

 def / (i: Int): Rational8 =
 new Rational8(numer, denom * i)

 override def toString = numer + "/" + denom

 private def gcd(a: Int, b: Int): Int =
 if (b == 0) a else gcd(b, a % b)
 }

object Rational {
  new Rational1(1, 2)
  println(new Rational2(3, 4))
  val rational = new Rational8(2, 54)
}
