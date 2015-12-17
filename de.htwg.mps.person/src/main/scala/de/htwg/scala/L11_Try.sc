import scala.util.{ Try, Success, Failure }

object L11_Try {

  def divide(a: Int, b: Int) = Try((a / b, a % b))//> divide: (a: Int, b: Int)scala.util.Try[(Int, Int)]

  val try1 = divide(4, 2)                         //> try1  : scala.util.Try[(Int, Int)] = Success((2,0))
  val try2 = divide(412, 20)                      //> try2  : scala.util.Try[(Int, Int)] = Success((20,12))
  val try3 = divide(0, 4)                         //> try3  : scala.util.Try[(Int, Int)] = Success((0,0))
  val try4 = divide(4, 0)                         //> try4  : scala.util.Try[(Int, Int)] = Failure(java.lang.ArithmeticException: 
                                                  //| / by zero)
  try1 match {
    case Success((div, remainder)) => println(div + ", Rest " + remainder)
    case Failure(exception) => println("Fehler: " + exception)
  }                                               //> 2, Rest 0

  def printResult(tri: Try[(Int, Int)]) = tri match {
    case Success((div, remainder)) => println(div + ", Rest " + remainder)
    case Failure(exception) => println("Fehler: " + exception)
  }                                               //> printResult: (tri: scala.util.Try[(Int, Int)])Unit

  printResult(try1)                               //> 2, Rest 0
  printResult(try4)                               //> Fehler: java.lang.ArithmeticException: / by zero

  for (r <- divide(4, 2)) yield r                 //> res0: scala.util.Try[(Int, Int)] = Success((2,0))
  for (r <- try1) yield r                         //> res1: scala.util.Try[(Int, Int)] = Success((2,0))

  val list = List(try1, try2, try3, try4)         //> list  : List[scala.util.Try[(Int, Int)]] = List(Success((2,0)), Success((20,
                                                  //| 12)), Success((0,0)), Failure(java.lang.ArithmeticException: / by zero))

  //for ( tri <- list; r <- tri  ) yield r
}