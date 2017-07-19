package ProjectEuler

/**
  * Problem 1
  *
  * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of
  * these multiples is 23.
  *
  * Find the sum of all the multiples of 3 or 5 below 1000.
  */

object MultiplesOf3and5 extends App {

  val limit = 1000
  val zero = 0

  val result = for (i <- zero until limit) yield {
    i match {
      case _ if i % 5 == 0 => i
      case _ if i % 3 == 0 => i
      case _ => 0
    }
  }

  print(result.sum)

}
