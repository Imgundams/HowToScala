package Chap4

import ChecksumAccumulator.calculate

class Summer {
  def main(args: Array[String]) = {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}
