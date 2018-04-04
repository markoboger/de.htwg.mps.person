import scala.util.{ Try, Success, Failure }


def divide(a: Int, b: Int) = Try((a / b, a % b))
val try1 = divide(4, 2)
val try2 = divide(412, 20)
val try3 = divide(0, 4)
val try4 = divide(4, 0)

try1 match {
  case Success((div, remainder)) => println(div + ", Rest " + remainder)
  case Failure(exception) => println("Fehler: " + exception)
}

def printResult(tri: Try[(Int, Int)]) = tri match {
  case Success((div, remainder)) => println( div + ", Rest " + remainder)
  case Failure(exception) => println("Fehler: " + exception)
}

printResult(try1)
printResult(try4)

for (r <- divide(4, 2)) yield r
for (r <- try1) yield r

val trylist = List(try1, try2, try3, try4)

for ( tries <- trylist  ) yield tries

val tuplelist = List((4,2),(412,20),(0,4),(4,0))

for(tuple <- tuplelist)
  yield printResult(divide(tuple._1,tuple._2))

