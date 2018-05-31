package Chap5

class IntegerLiterals {
  // 0x or 0X makes it hexadecimal (base16) 0-9A-F
  val hex = 0x5
  val hex2 = 0x00FF
  val magic = 0xcafebabe

  val dec1 = 31
  val dec2 = 255
  val dec3 = 20

  // if (integer Literal ends in L or l) Long else Int
  val prog = 0xCAFEBABEL
  prog: Long

  val tower = 35L
  tower: Long
  val of = 31l
  of: Long

  val little: Short = 367
  little: Short
  val littler: Byte = 38
  littler: Byte

  //  Floating Pint literals
  val big = 1.2345
  big: Double
  val bigger = 1.2345e1
  bigger: Double
  val biggerStill = 1.23E45
  biggerStill: Double
  //  Exponent on the end of the number is ^10
  val littleFloat = 1.2345F
  littleFloat: Float
  val littleBiggerFloat = 3e5f
  littleBiggerFloat: Float
  //  As Double
  val anotherDouble = 3e5
  anotherDouble: Double
  val yetAnotherDouble = 3e5D
  yetAnotherDouble: Double

//  Character Literals
//  They are composed of unicodes between ''
  val characterA = 'A'
  characterA :Char
//  unicodes need a escape key for the u before the code
  val characterAUnicode = '\u0041'
  characterAUnicode
  val characterDUnicode = '\u0044'
  characterDUnicode
//  String Literals
  val hello = "hello"
  hello: String
  val escapes = "\\\"\'"
  escapes
//  We can use """ """ to put json bodies for allowing quotes in string without escaping
  val blockString =
    """Hello
      |there is "nothing"
      |here
      |Good\"bye"/
    """.stripMargin
  blockString:String
}
