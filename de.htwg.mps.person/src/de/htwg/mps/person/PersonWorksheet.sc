package de.htwg.mps.person

object PersonWorksheet {
  
  val peter = new Person("Peter", new Date(2008,7,4))
                                                  //> peter  : de.htwg.mps.person.Person = Person(Peter,2008-7-4)
  val paul = new Person("Paul", new Date(1995,12,31))
                                                  //> paul  : de.htwg.mps.person.Person = Person(Paul,1995-12-31)
  val mary = new Person("Mary", new Date(1965, 1,1))
                                                  //> mary  : de.htwg.mps.person.Person = Person(Mary,1965-1-1)
   def greeting(p: Person) = p match {
    case kid if (kid.age <= 12) => "Hello " + kid.name
    case teen if (teen.age < 20) => "Hey " + teen.name
    case twen if (twen.age < 30) => "Hi " + twen.name
    case adult if (adult.age < 60) => "Welcome " + adult.name
    case _ => "Welcome " + p.name
  }                                               //> greeting: (p: de.htwg.mps.person.Person)String
  
  val list = List(peter, paul, mary)              //> list  : List[de.htwg.mps.person.Person] = List(Person(Peter,2008-7-4), Perso
                                                  //| n(Paul,1995-12-31), Person(Mary,1965-1-1))
  list.foreach(p => println(greeting(p)))         //> Hello Peter
                                                  //| Hey Paul
                                                  //| Welcome Mary
}