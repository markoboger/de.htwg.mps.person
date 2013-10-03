package de.htwg.mps.person

object PersonWorksheet {
  
  val peter = new Person("Peter", new Date(1971,7,4))
                                                  //> peter  : de.htwg.mps.person.Person = de.htwg.mps.person.Person@698c10b8
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
                                                  //> paul  : de.htwg.mps.person.Person = de.htwg.mps.person.Person@49427381
  paul.age                                        //> res9: Int = 41
  peter > paul                                    //> res10: Boolean = true
  peter < paul                                    //> res11: Boolean = false
  paul < peter                                    //> res12: Boolean = true
  paul > peter                                    //> res13: Boolean = false
  
  val mary = new Person("Mary", new Date(1965, 1,1))
                                                  //> mary  : de.htwg.mps.person.Person = de.htwg.mps.person.Person@29ad3fba
  peter > mary                                    //> res14: Boolean = false
  mary > peter                                    //> res15: Boolean = true
}