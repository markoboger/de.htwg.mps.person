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
  
  trait Ordered[A] {
 	 	def compare(that: A): Int
  	def <(that: A): Boolean = (this compare that) < 0
  	def >(that: A): Boolean = (this compare that) > 0
  	def <=(that: A): Boolean = (this compare that) <= 0
  	def >=(that: A): Boolean = (this compare that) >= 0
	}
  
	class Date(val year:Int, val month:Int, val day:Int) extends Ordered[Date] {
	  override def compare(that: Date) = {
    	if (this.year != that.year) this.year - that.year
    	else if (this.month != that.month) this.month - that.month
    	else this.day - that.day
  	}
	  def anniversary(nth:Int) = new Date(year+nth, month, day)
  	def anniversary = new Date(Today.year, month, day)
  	def fullYearsSince(date: Date):Int = if (this <= date) {
    	if (this.anniversary <= date.anniversary) date.year - year  else date.year - year -1
  	} else 0
		def fullYearsSince:Int=fullYearsSince(Today.date)
	}

  class Person(val name:String, val birthdate:Date){
  	def age = birthdate.fullYearsSince
  }
  
  val peter = new Person("Peter", new Date(1971,7,4))
                                                  //> peter  : de.htwg.mps.person.PersonWorksheet.Person = de.htwg.mps.person.Per
                                                  //| sonWorksheet$$anonfun$main$1$Person$1@2048a158
  peter.name                                      //> res1: String = Peter
  peter.age                                       //> res2: Int = 42
  
  val paul = new Person("Paul", new Date(1971,12,31))
                                                  //> paul  : de.htwg.mps.person.PersonWorksheet.Person = de.htwg.mps.person.Pers
                                                  //| onWorksheet$$anonfun$main$1$Person$1@25cc8345
  paul.age                                        //> res3: Int = 41
}