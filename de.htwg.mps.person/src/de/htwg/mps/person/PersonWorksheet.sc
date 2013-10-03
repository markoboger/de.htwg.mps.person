package de.htwg.mps.person

object PersonWorksheet {

  class Person(val name:String, val yearOfBirth:Int){
  	def age = 2013 - yearOfBirth
  }
  
  val peter = new Person("Peter", 1971)           //> peter  : de.htwg.mps.person.PersonWorksheet.Person = de.htwg.mps.person.Pers
                                                  //| onWorksheet$Person@16c82102
  peter.name.toString                             //> res0: String = Peter
  peter.age.toString                              //> res1: String = 42
}