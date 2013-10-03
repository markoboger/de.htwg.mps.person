package de.htwg.mps.person

object PersonWorksheet {
  1+2                                             //> res0: Int(3) = 3
  println("Hello World")                          //> Hello World
  3.toString                                      //> res1: String = 3
  
  val message="Hello World"                       //> message  : String = Hello World
  println(message)                                //> Hello World
  
  var day=23                                      //> day  : Int = 23
  day = day+1
  day.toString                                    //> res2: String = 24
  
  def max(a:Int, b:Int) = if (a>b) a else b       //> max: (a: Int, b: Int)Int
  max(17,4)                                       //> res3: Int = 17
  max(4,17)                                       //> res4: Int = 17
  
  class Person(name:String)
  
  val peter = new Person("Peter")                 //> peter  : de.htwg.mps.person.PersonWorksheet.Person = de.htwg.mps.person.Pers
                                                  //| onWorksheet$$anonfun$main$1$Person$1@65654dfb
}