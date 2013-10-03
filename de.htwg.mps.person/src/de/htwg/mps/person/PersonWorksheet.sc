package de.htwg.mps.person

object PersonWorksheet {
  
  val peter = new Person("Peter", new Date(1971,7,4))
                                                  //> peter  : de.htwg.mps.person.Person = de.htwg.mps.person.Person@7e02286
  peter.name                                      //> res0: String = Peter
  peter.age                                       //> res1: Int = 42
  peter.age(new Date(1971,7,4))                   //> res2: Int = 0
  peter.age(new Date(1972,7,3))                   //> res3: Int = 0
  peter.age(new Date(1972,7,4))                   //> res4: Int = 1
  peter.age(new Date(1972,7,5))                   //> res5: Int = 1
  peter.age(new Date(1972,6,4))                   //> res6: Int = 0
  peter.age(new Date(1972,7,4))                   //> res7: Int = 1
  peter.age(new Date(1972,8,4))                   //> res8: Int = 1
  
  val paul = new Person("Paul", new Date(1971,12,31))
                                                  //> paul  : de.htwg.mps.person.Person = de.htwg.mps.person.Person@1d44eef3
  paul.age                                        //> res9: Int = 41
}