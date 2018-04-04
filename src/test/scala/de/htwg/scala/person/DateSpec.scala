package de.htwg.scala.person

import org.scalatest.WordSpec
import org.scalatest.Matchers._

class DateSpec extends WordSpec {
  
  "A Date" should {
    "have a year" in {
      Date(1999,12,31).year should be(1999)
    }
    "have a month" in {
      Date(1999,12,31).month should be(12)
    }
    "have a day" in {
      Date(1999,12,31).day should be(31)
    }
  }
  
  "The default Date" should {
    "be today" in {
      val today  = Date()
      today.year should be( Today.year) 
      today.month should be (Today.month)
      today.day should be (Today.day)
    }
  }
  
  "the nth Anniversary of a Date" should {
    "be n years after that date" in {
      Date(2000,1,1).anniversary(1) should be(Date(2001,1,1))
    }
  }
  
  "the Anniversary of a Date" should {
    "be the Day of that Date in the current year" in {
      Date(2000,1,1).anniversary should be(Date(Today.year,1,1))
    }
    "be greater that the Date" in {
      val date = Date(2000,1,1)
      val anniv = date.anniversary(5)
      assert(date < anniv)
      assert(anniv > date)
    }
  }
  
  "Full years since a Date" should {
    "be zero if the Date is before today" in {
      Date(Today.year, Today.month, Today.day).fullYearsSince should be(0)
    }
    "be one if the Date one year ago" in {
      Date(Today.year - 1, Today.month, Today.day).fullYearsSince should be(1)
    }
    "be n if the Date n years ago" in {
      Date(Today.year - 30, Today.month, Today.day).fullYearsSince should be(30)
    }
  }
  
  "Compare" should {
    "be zero for the same date" in {
      Date(2000,1,1).compare(Date(2000,1,1)) should be (0)
    }
    "smaller zero for later dates" in {
      Date(2000,1,1).compare(Date(2000,2,1)) should be < 0
    }
    "greater zero for earlier dates" in {
      Date(2000,1,1).compare(Date(1999,31,12)) should be > 0
    }
  }
  
}