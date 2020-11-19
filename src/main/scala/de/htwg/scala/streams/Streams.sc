
Stream.from(1) take 20 toList

Stream.from(1,2) take 20 toList

def fib1: Stream[Int] = {
  def loop(a: Int, b: Int): Stream[Int] = a  #:: loop(b, a + b)
  loop(0, 1)
}

fib1 take 20 toList

def fib2:Stream[Int] ={
  def loop(a: Int, b:Int): Stream[Int] = Stream.cons(a,loop(b,a+b))
  loop(0,1)
}

fib2 take 20 toList

def fib3(a: Int = 0, b: Int = 1): Stream[Int] = a #:: fib3(b, a+b)

fib3() take 20 toList

def fib4(a: Int , b: Int): Stream[Int] = a #:: fib4(b, a+b)

fib4(0,1) take 20 toList

val fib5: Stream[Int] = 0 #:: fib5.scanLeft(1)(_ + _)

fib5 take 20 toList

val fib6:Stream[Int] = 0 #:: 1 #:: (fib6 zip fib6.tail).map{ t => t._1 + t._2}
fib6 take 20 toList

val fib7:Stream[Int] = 0 #:: 1 #:: (fib7 zip fib7.tail).map{
  t => {
    println("Adding %d and %d".format(t._1, t._2))
    t._1 + t._2
  }
}

fib7 take 10 toList

fib7 take 20 toList

fib7 take 5 foreach println

def primeStream(s: Stream[Int]): Stream[Int] = s.head #:: primeStream(s.tail filter { _ % s.head != 0 })
val primes = primeStream(Stream.from(2))
primes take 100 foreach println
