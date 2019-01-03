object echoargs {
  def enterArrayOfArgs(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      if (i != 0)
        print(" ")
      print(args(i))
      i += 1
    }
    println()

    println("Hello, World!")

    println("Hello, " + args(0) + "!")

    args.foreach(arg => println(arg))
    // Explicitly state type
    // args.foreach((arg:String) => println(arg))

    var j = 0
    while (j < args.length) {
      println(args(j))
      j += 1
    }
  }
}