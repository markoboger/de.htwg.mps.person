package de.htwg.mps.time

object time {
//Java inside Scala!!!
//Java Construtor, Getter and Equals
  var jtime1 = new JavaTime(8, 10)
  jtime1.getHours()
  jtime1.getAsMinutes()
  jtime1 == new JavaTime(8, 40)
  jtime1.plus(new JavaTime(0,70))
  println(jtime1)
 	jtime1 == new JavaTime(9,0)

//Scala Construtor
	new Time(8,40)
  Time
  Time()
  Time(minutes = 45)
  Time(minutes = 45, hours = 1)

//Getter and Equals
  val stime1 = new Time(8, 40)
  stime1.hours
  Time(8, 40) == Time(8, 40)

//Operator as method in infix notation
  Time(8, 40) + Time(8, 40)

//Reassignment and +=
  var stime2 = Time(8,40)
  stime2 = stime2 + Time(0,20)
  println(stime2)
  stime2 += Time(0,20)
  println(stime2)



}