package de.htwg.scala.person

object PersonDemo2 {

  class Person(val name: String, val birthdate: Date) {
    def age = birthdate.fullYearsSince
    def age(date: Date) = birthdate.fullYearsSince(date)
  }

  val marko = new Person("Marko", new Date(1969, 5, 23))
  marko.name
  marko.age == 46
  marko.age(new Date(2000, 1, 1))
  Today.now
}