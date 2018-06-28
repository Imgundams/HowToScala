package Chap9

import java.io.File

class ControlAstraction {

  // Reducing code duplication
  object FileMatcherOriginal {
    private def filesHere = (new File(".")).listFiles

    def filesEnding(query: String) =
      for (file <- filesHere
           if file.getName.endsWith(query)
      ) yield file

    def filesContaining(query: String) =
      for (file <- filesHere
           if file.getName.contains(query)
      ) yield file

    def filesRegex(query: String) =
      for (file <- filesHere
           if file.getName.matches(query)
      ) yield file
  }

  object FileMatcherOptimised {
    private def filesHere = (new File(".")).listFiles

    private def filesMatching(query: String, matcher: (String, String) => Boolean) = {
      for (file <- filesHere
           if (file.getName, query)
      ) yield file
    }
    def filesEnding(query: String) =
      filesMatching(query, _.endsWith(_))
    def filesContaining(query: String) =
      filesMatching(query,_.contains(_))
    def filesRegex(query: String) =
      filesMatching(query,_.matches(_))
//    The function literal _.endsWith(_) means the same thing as
//    (fileName:String, query: String) => fileName.endsWith(query)
  }
  object FileMatcherRefactoredOptimised {
    private def filesHere = (new File(".")).listFiles

    private def filesMatching(matcher: String => Boolean) = {
      for (file <- filesHere
           if matcher(file.getName)
      ) yield file
    }
    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))
    def filesContaining(query: String) =
      filesMatching(_.contains(query))
    def filesRegex(query: String) =
      filesMatching(_.matches(query))
  }

//  Simplifiying Client Code
// Its important to use high-order functions to reduce code duplication
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
  for (num <- nums)
    if (num < 0)
      exists = true
  exists
}
  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num % 2 == 1)
        exists = true
    exists
  }

  def containsNegRefactored(nums: List[Int]) = nums.exists(_ < 0)
  def containsOddRefactored(nums:List[Int]) = nums.exists(_ % 2 ==1)

  //currying
  def plainOldSum(x: Int, y:Int) = x + y
  def curriedSum(x: Int)(y: Int) = x + y
  def first(x:Int)= (y: Int) => x+y

  //Writing new control structures,

  def twice(op: Double => Double, x: Double) = op(op(x))


}
