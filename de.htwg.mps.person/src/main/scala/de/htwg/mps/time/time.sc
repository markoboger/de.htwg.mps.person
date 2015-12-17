package de.htwg.mps.time

object time {
//Java inside Scala!!!
//Java Construtor, Getter and Equals
  var jtime1 = new JavaTime(8, 10)                //> jtime1  : de.htwg.mps.time.JavaTime = 08:10
  jtime1.getHours()                               //> res0: Int = 8
  jtime1.getAsMinutes()                           //> res1: Int = 490
  jtime1 == new JavaTime(8, 40)                   //> res2: Boolean = false
  jtime1.plus(new JavaTime(0,70))
  println(jtime1)                                 //> 09:20
 	jtime1 == new JavaTime(9,0)               //> res3: Boolean = false

//Scala Construtor
	new ScalaTime(8,40)                       //> res4: de.htwg.mps.time.ScalaTime = 08:40
  ScalaTime                                       //> res5: de.htwg.mps.time.ScalaTime.type = ScalaTime
  ScalaTime()                                     //> res6: de.htwg.mps.time.ScalaTime = 00:00
  ScalaTime(minutes = 45)                         //> res7: de.htwg.mps.time.ScalaTime = 00:45
  ScalaTime(minutes = 45, hours = 1)              //> res8: de.htwg.mps.time.ScalaTime = 01:45

//Getter and Equals
  val stime1 = new ScalaTime(8, 40)               //> stime1  : de.htwg.mps.time.ScalaTime = 08:40
  stime1.hours                                    //> res9: Int = 8
  ScalaTime(8, 40) == ScalaTime(8, 40)            //> res10: Boolean = true

//Operator as method in infix notation
  ScalaTime(8, 40) + ScalaTime(8, 40)             //> res11: de.htwg.mps.time.ScalaTime = 17:20

//Reassignment and +=
  var stime2 = ScalaTime(8,40)                    //> stime2  : de.htwg.mps.time.ScalaTime = 08:40
  stime2 = stime2 + ScalaTime(0,20)
  println(stime2)                                 //> 09:00
  stime2 += ScalaTime(0,20)
  println(stime2)                                 //> 09:20



}