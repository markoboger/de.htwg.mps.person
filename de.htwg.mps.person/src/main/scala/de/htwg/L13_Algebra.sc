package de.htwg

object L13_Algebra {
  import spire.math.Integral
  import spire.math.Rational
  import spire.math.Complex
	import spire.implicits._
	
	val d1 = 2/3.0                            //> d1  : Double = 0.6666666666666666
	val d2 = 1/3.0                            //> d2  : Double = 0.3333333333333333
	val d3 = d1+d2                            //> d3  : Double = 1.0
	
	val r1 = r"2/3"                           //> r1  : spire.math.Rational = 2/3
	val r2=Rational(1,3)                      //> r2  : spire.math.Rational = 1/3
	
	val r3 = r1 + r2                          //> r3  : spire.math.Rational = 1
	
	val ci1=Complex(2,1)                      //> ci1  : spire.math.Complex[Int] = (2 + 1i)
	val ci2 = Complex(3,4)                    //> ci2  : spire.math.Complex[Int] = (3 + 4i)
	val ci3 = ci1+ci2                         //> ci3  : spire.math.Complex[Int] = (5 + 5i)
	
	val cd1=Complex(2.0,1)                    //> cd1  : spire.math.Complex[Double] = (2.0 + 1.0i)
	val cd2 = Complex(3.0,4)                  //> cd2  : spire.math.Complex[Double] = (3.0 + 4.0i)
	val cd3 = cd1+cd2                         //> cd3  : spire.math.Complex[Double] = (5.0 + 5.0i)
	
	Vector(1,5,3) + Vector(2,1,-5)            //> res0: scala.collection.immutable.Vector[Int] = Vector(3, 6, -2)
	4.0 *: Vector(1.0,5.0,3.0)                //> res1: scala.collection.immutable.Vector[Double] = Vector(4.0, 20.0, 12.0)
	
  def euclidGcd[A: Integral](x: A, y: A): A =
	  if (y == 0) x
	  else euclidGcd(y, x % y)                //> euclidGcd: [A](x: A, y: A)(implicit evidence$2: spire.math.Integral[A])A
	  
  euclidGcd(42, 96)                               //> res2: Int = 6
	euclidGcd(42L, 96L)                       //> res3: Long = 6
	euclidGcd(BigInt(42), BigInt(96))         //> res4: scala.math.BigInt = 6

}