package de.htwg.scala.time

object TimeWorksheet {
//Java inside Scala!!!
//Java Construtor, Getter and Equals
  var jtime1 = new JavaTime(8, 10)                //> jtime1  : de.htwg.scala.time.JavaTime = 08:10
  jtime1.getHours()                               //> res0: Int = 8
  jtime1.getAsMinutes()                           //> res1: Int = 490
  jtime1 == new JavaTime(8, 40)                   //> res2: Boolean = false
  jtime1.plus(new JavaTime(0,70))
  println(jtime1)                                 //> 09:20
 	jtime1 == new JavaTime(9,0)               //> res3: Boolean = false

//Scala Construtor
	new Time(8,40)                            //> res4: de.htwg.scala.time.Time = 08:40
  Time(0,0)                                       //> res5: de.htwg.scala.time.Time = 00:00
  Time(minutes = 45)                              //> res6: de.htwg.scala.time.Time = 00:45
  Time(minutes = 45, hours = 1)                   //> res7: de.htwg.scala.time.Time = 01:45
//Getter and Equals
  val stime1 = new Time(8, 40)                    //> stime1  : de.htwg.scala.time.Time = 08:40
  stime1.hours                                    //> res8: Int = 8
  Time(8, 40) == Time(8, 40)                      //> res9: Boolean = true

//Operator as method in infix notation
  Time(8, 40) + Time(8, 40)                       //> res10: de.htwg.scala.time.Time = 17:20

//Reassignment and +=
  var stime2 = Time(8,40)                         //> stime2  : de.htwg.scala.time.Time = 08:40
  stime2 = stime2 + Time(0,20)
  println(stime2)                                 //> 09:00
  stime2 += Time(0,20)
  println(stime2)                                 //> 09:20
}