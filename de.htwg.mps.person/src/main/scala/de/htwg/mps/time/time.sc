package de.htwg.mps.time

object time {
//Java inside Scala!!!
//Java Construtor, Getter and Equals
  val jtime1 = new JavaTime(8, 41)
  jtime1.getHours()
  new JavaTime(8, 40) == new JavaTime(8, 40)

//Scala Construtor
	new ScalaTime(8,40)
  ScalaTime
  ScalaTime()
  ScalaTime(minutes = 45)
  ScalaTime(minutes = 45, hours = 1)

//Getter and Equals
  val stime1 = new ScalaTime(8, 40)
  stime1.hours
  ScalaTime(8, 40) == ScalaTime(8, 40)

//Operator as method in infix notation
  ScalaTime(8, 40) + ScalaTime(8, 40)

//Reassignment and +=
  var stime2 = ScalaTime(8,40)
  stime2 = stime2 + ScalaTime(0,20)
  println(stime2)
  stime2 += ScalaTime(0,20)
  println(stime2)



}