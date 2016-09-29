package de.htwg.scala.person

object PersonWorksheet {
  1+2+3                                           //> res0: Int = 6
  
  val peter = new Person("Peter", new Date(2009,7,4))
                                                  //> peter  : de.htwg.scala.person.Person = Person(Peter,2009-7-4)
  peter.age                                       //> res1: Int = 7
  peter.age(new Date (2012,1,1))                  //> res2: Int = 2
  val paul = Person("Paul", new Date(1995,12,31)) //> paul  : de.htwg.scala.person.Person = Person(Paul,1995-12-31)
  val mary = Person("Mary", new Date(1965, 1,1))  //> mary  : de.htwg.scala.person.Person = Person(Mary,1965-1-1)
  mary.age                                        //> res3: Int = 51
  mary.age( Date(1966,1,1))                       //> res4: Int = 1
  mary.age( Date(1965,12,31))                     //> res5: Int = 0
  
  peter < mary                                    //> res6: Boolean = true
  paul > peter                                    //> res7: Boolean = true
  peter < paul && paul < mary                     //> res8: Boolean = true
  
   def greeting(p: Person) = p match {
    case kid if (kid.age <= 12) => "Hello " + kid.name
    case teen if (teen.age < 20) => "Hey " + teen.name
    case twen if (twen.age < 30) => "Hi " + twen.name
    case adult if (adult.age < 60) => "Welcome " + adult.name
    case _ => "Welcome " + p.name
  }                                               //> greeting: (p: de.htwg.scala.person.Person)String
  
  val list = List(peter, paul, mary)              //> list  : List[de.htwg.scala.person.Person] = List(Person(Peter,2009-7-4), Per
                                                  //| son(Paul,1995-12-31), Person(Mary,1965-1-1))
  list.foreach(p => println(greeting(p)))         //> Hello Peter
                                                  //| Hi Paul
                                                  //| Welcome Mary
}