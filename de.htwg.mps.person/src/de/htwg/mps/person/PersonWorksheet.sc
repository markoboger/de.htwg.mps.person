package de.htwg.mps.person

import com.github.nscala_time.time.Imports.DateTime
object PersonWorksheet {
1+2                                               //> res0: Int(3) = 3
  object Today {
  	def now = DateTime.now
  	def year = now.getYear
  	def month = now.getMonthOfYear()
  	def day = now.getDayOfMonth()
  	def date = new Date(year, month, day)
  }
  
	class Date(year:Int, month:Int, day:Int){
		def fullYearsSince(day:Date):Int = 42
		def fullYearsSince:Int=fullYearsSince(Today.date)
	}

  class Person(val name:String, val birthdate:Date){
  	def age = birthdate.fullYearsSince

  }
  
  val peter = new Person("Peter", new Date(1971,7,4))
                                                  //> peter  : de.htwg.mps.person.PersonWorksheet.Person = de.htwg.mps.person.Pers
                                                  //| onWorksheet$$anonfun$main$1$Person$1@57160a60
  peter.name                                      //> res1: String = Peter
  peter.age                                       //> res2: Int = 42
}