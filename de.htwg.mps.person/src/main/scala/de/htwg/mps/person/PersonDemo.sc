package de.htwg.mps.person

object PersonDemo {
  1 + 2                                           //> res0: Int(3) = 3

import com.github.nscala_time.time.Imports.DateTime

  object Today {
    def now = DateTime.now
    def year = now.getYear
    def month = now.getMonthOfYear()
    def day = now.getDayOfMonth()
    def date = new Date(year, month, day)
  }

  class Date(val year: Int, val month: Int, val day: Int) extends Ordered[Date] {
    override def compare(that: Date) = {
      if (this.year != that.year) this.year - that.year
      else if (this.month != that.month) this.month - that.month
      else this.day - that.day
    }
    def anniversary(nth: Int) = new Date(year + nth, month, day)
    def anniversary = new Date(Today.year, month, day)
    def fullYearsSince(that: Date): Int = if (this <= that) {
      if (this.anniversary <= that.anniversary) that.year - year else that.year - year - 1
    } else 0
    def fullYearsSince: Int = fullYearsSince(Today.date)
    override def toString = year + "-" + month + "-" + day
  }

  class Person(val name: String, val birthdate: Date) {
    def age = birthdate.fullYearsSince
  }

  val marko = new Person("Marko", new Date(1969, 5, 23))
                                                  //> marko  : de.htwg.mps.person.PersonDemo.Person = de.htwg.mps.person.PersonDe
                                                  //| mo$$anonfun$main$1$Person$1@7cec9b3a
  marko.name                                      //> res1: String = Marko
  marko.age                                       //> res2: Int = 45
  marko.birthdate.anniversary                     //> res3: de.htwg.mps.person.PersonDemo.Date = 2014-5-23
  marko.birthdate.anniversary(50)                 //> res4: de.htwg.mps.person.PersonDemo.Date = 2019-5-23
  
  val date1 = new Date(2000,1,1)                  //> date1  : de.htwg.mps.person.PersonDemo.Date = 2000-1-1
  val date2 = new Date(2000,2,2)                  //> date2  : de.htwg.mps.person.PersonDemo.Date = 2000-2-2
  date1 < date2                                   //> res5: Boolean = true
}