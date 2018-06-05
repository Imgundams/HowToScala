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
      numerator * that.denominator +
        that.numerator * denominator,
      denominator * that.denominator)

}


new Rational1(1, 2)
println(new Rational2(3, 4))
