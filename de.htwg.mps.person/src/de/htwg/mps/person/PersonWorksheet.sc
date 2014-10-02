package de.htwg.mps.person

object PersonWorksheet {
  1+2
  val peter = new Person("Peter", new Date(2008,7,4))
  val paul = new Person("Paul", new Date(1995,12,31))
  val mary = new Person("Mary", new Date(1965, 1,1))
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