package de.htwg.scala.person

object PersonWorksheet {
  1+2+3
  
  val peter = new Person("Peter", new Date(2008,7,4))
  peter.age
  peter.age(new Date (2012,1,1))
  val paul = Person("Paul", new Date(1995,12,31))
  val mary = Person("Mary", new Date(1965, 1,1))
  mary.age
  mary.age( Date(1966,1,1))
  mary.age( Date(1965,12,31))
  
  
  
  
   def greeting(p: Person) = p match {
    case kid if (kid.age <= 12) => "Hello " + kid.name
    case teen if (teen.age < 20) => "Hey " + teen.name
    case twen if (twen.age < 30) => "Hi " + twen.name
    case adult if (adult.age < 60) => "Welcome " + adult.name
    case _ => "Welcome " + p.name
  }
  
  val list = List(peter, paul, mary)
  list.foreach(p => println(greeting(p)))
}