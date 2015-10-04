package de.htwg.mps.person

object PersonDemo2 {

  class Person(val name: String, val birthdate: Date) {
    def age = birthdate.fullYearsSince
    def age(date: Date) = birthdate.fullYearsSince(date)
  }

  val marko = new Person("Marko", new Date(1969, 5, 23))
                                                  //> marko  : de.htwg.mps.person.PersonDemo2.Person = de.htwg.mps.person.PersonDe
                                                  //| mo2$Person@48f4104f
  marko.name                                      //> res0: String = Marko
  marko.age == 46                                 //> res1: Boolean = true
  marko.age(new Date(2000, 1, 1))                 //> res2: Int = 30
  Today.now                                       //> res3: org.joda.time.DateTime = 2015-10-04T17:29:59.210+02:00
}