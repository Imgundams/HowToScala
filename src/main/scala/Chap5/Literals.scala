package Chap5

class Literals {
  // 0x or 0X makes it hexadecimal (base16) 0-9A-F
  val hex: Int = 0x5
  val hex2: Int = 0x00FF
  val magic: Int = 0xcafebabe

  val dec1: Int = 31
  val dec2: Int = 255
  val dec3: Int = 20

  // if (integer Literal ends in L or l) Long else Int
  val prog: Long = 0xCAFEBABEL

  val tower: Long = 35L
  val of: Long = 31l

  val little: Short = 367
  val littler: Byte = 38

  //  Floating Pint literals
  val big: Double = 1.2345
  val bigger: Double = 1.2345e1
  val biggerStill: Double = 1.23E45
  //  Exponent on the end of the number is ^10
  val littleFloat: Float = 1.2345F
  val littleBiggerFloat: Float = 3e5f
  //  As Double
  val anotherDouble: Double = 3e5
  val yetAnotherDouble: Double = 3e5D

  //  Character Literals
  //  They are composed of unicodes between ''
  val characterA: Char = 'A'
  //  unicodes need a escape key for the u before the code
  val characterAUnicode: Char = '\u0041'
  val characterDUnicode: Char = '\u0044'
  //  String Literals
  val hello: String = "hello"
  val escapes: String = "\\\"\'"
  escapes
  //  We can use """ """ to put json bodies for allowing quotes in string without escaping
  val blockString: String =
    """Hello
      |there is "nothing"
      |here
      |Good\"bye"/
    """.stripMargin
  blockString: String

  //  Symbol Literals
  def updateRecordsByName(symbol: Symbol, value: Any): Unit = {
    // code here ???
  }

  //  ' is the symbol literal this will return the associated name
  updateRecordsByName('ko, "OK")
  val s: Symbol = 'aSymbol
  val name: String = s.name
  name
  //  Boolean Literals
  val namename = "reader"
  val cantEscape = raw"////\\\\no escape characters"
  val pi = f"${math.Pi}%.5f"
  //Operators are Methods
  val sum1: Int = 1 + 2
  val sum2: Int = 1.+(2)
  val sum3: Long = 1 + 2L
  name indexOf('o', 3)
  // character and what index to start at
  //  Any method can be an operator
  val minusOnNumber: Double = -2.0
  val minusOpOnNumber: Double = (2.0).unary_-

  //  The only operators that can be used as prefix operators are
  //  +, -, ! and ~

  class UnaryStringTest(str: String) {
    def unary_! : String = str.reverse
  }

  val unaryTest = new UnaryStringTest("Hello Here is a String")
  println(!unaryTest)
  //  the dot is not needed in scala after the type and can be used
  //  like a postfix operator

  //  Arithmetic Operations
  val addingDoubles: Double = 1.2 + 2.3 //:Double = 3.5
  val subtraction: Int = 3 - 1 // = 2
  val subtractionChars: Int = 'b' - 'a' //:Int = 1
  val multiplicationLong: Long = 2L * 3L //:Long = 6
  val remainder: Int = 11 % 4 //:Int = 3
  val divisionFloat: Float = 11.0f / 4.0f //:Float = 2.75
  val remainderDouble: Double = 11.0 % 4.0 //:Double = 3.00
  val IEEEremainder: Double = math.IEEEremainder(11.0, 4.0) //:Double = -1.0
  val neg: Int = 1 + -3 //:Int = -2
  val positive3y: Int = +3 //:Int = 3
  //  -neg return 2

  //  Relational and Logical Operation
  val isOneGreaterThenTwo: Boolean = 1 > 2 //false
  val isOneLessThenTwo: Boolean = 1 < 2 //true
  val isOneLessThenOrEqualToOne: Boolean = 1 <= 1 //true
  val aTenthDifference: Boolean = 3.5f >= 3.6f //false
  val characterDifference: Boolean = 'a' >= 'A' //true
  val untrueTrue: Boolean = !true //false
  val toBe = true
  val question: Boolean = toBe || !toBe //true
  val paradox: Boolean = toBe && !toBe //false

  // The && and || are short-circuit operations they only evaluate as far as they need to be.
  // To not use the short-circuit operations you can use the & and |
  def kick(): Boolean = {println("kick");false}
  def punch(): Boolean = {println("punch");true}
  kick() && punch() || punch() && kick()

  // Bitwise Operations
  val bitwise01AND10: Int = 1 & 2
  val bitwise01OR10: Int = 1 | 2
  val bitwise01XOR11: Int = 1 ^ 3
  val bitwiseINVERT01: Int = ~1
  val bitwiseShift111111: Int = -1>>31
  val bitwiseUnsignedShift111111: Int = -1>>>31 // = 1
  val bitwiseShiftLeft1: Int = 1<<2 // = 4

  val equalTo: Boolean = 1 == 2
  val notEqualTo: Boolean = 1 != 2
  val equalToTrue: Boolean = 2 == 2
  val listEqualTo: Boolean = List(1,2,3) == List(1,2,3)
  val listEqualToFalse: Boolean = List(1,2,3) == List(4,5,6)
  val listEqualToString: Boolean = List(1,2,3) == "hello"
  val listEqualToNull: Boolean = List(1,2,3) == null
  val NullEqualTolist: Boolean = null == List(1,2,3)
  val sameStringEquality: Boolean = ("he"+"l"+"lo") == "hello"

  // Operator Precedence and Associativity
  // Order of Precedence left to right (SpecialChars),*/%,+-,:,=!,<>,&,^,|,(letters),(assignment Ops)

}