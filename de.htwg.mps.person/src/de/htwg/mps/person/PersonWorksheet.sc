package de.htwg.mps.person

object PersonWorksheet {

  class Person(val name:String, val age:Int)
  
  val peter = new Person("Peter", 42)             //> peter  : de.htwg.mps.person.PersonWorksheet.Person = de.htwg.mps.person.Pers
                                                  //| onWorksheet$Person@5a0ce5a6
  peter.name.toString                             //> res0: String = Peter
  peter.age.toString                              //> res1: String = 42
}