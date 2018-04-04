package de.htwg.scala.time

import org.scalatest.WordSpec
import org.scalatest.Matchers._

class TimeSpec extends WordSpec {

  "Time" should {
    "be easy to create" in {
      Time() shouldBe a[Time]
      Time(8, 40) shouldBe a[Time]
      new Time(8, 40) shouldBe a[Time]
      Time(minutes = 45) shouldBe a[Time]
      Time(minutes = 45, hours = 1) shouldBe a[Time]
    }
    "have equality for same time values" in {
      Time should be(Time)
      Time(0, 0) should be(Time(0, 0))
      Time(3, 40) should be(Time(3, 40))
      Time(24, 0) should be(Time(0, 0))
    }
    "have inequality for different time values or types" in {
      Time(0, 0) should not equal (Time(2, 34))
      Time should not equal ("00:00")
    }
    "have a string representation formated like 00:00" in {
      Time(0, 0).toString() should be("00:00")
      Time(0, 10).toString() should be("00:10")
      Time(0, 60).toString() should be("01:00")
      Time(minutes = 70).toString() should be("01:10")
      Time(8, 40).toString() should be("08:40")
    }
  }
  "Addition" should {
    "add hours and minutes" in {
      Time(0, 0) + Time(0, 0) should be(Time(0, 0))
      Time(1, 20) + Time(2, 30) should be(Time(3, 50))
    }
    "role over when minutes exceed 60" in {
      Time(0, 0) + Time(0, 70) should be(Time(1, 10))
      Time(0, 70) + Time(0, 0) should be(Time(1, 10))
      Time(0, 20) + Time(0, 40) should be(Time(1, 0))
    }
    "role over when hours exceed 24" in {
      Time(0, 0) + Time(24, 0) should be(Time(0, 0))
      Time(24, 0) + Time(0, 0) should be(Time(0, 0))
      Time(24, 0) + Time(24, 0) should be(Time(0, 0))
    }
  }
  "Subtraction" should {
    "subtract hours and minutes" in {
      Time(2, 0) - Time(1, 0) should be(Time(1, 0))
      Time(0, 30) - Time(0, 20) should be(Time(0, 10))
      Time(3, 40) - Time(1, 20) should be(Time(2, 20))
    }
    "role over when minutes go below 0" in {
      Time(1, 0) - Time(0, 10) should be(Time(0, 50))
    }
    "role over when hours go below 0" in {
      Time(0, 0) - Time(0, 10) should be(Time(23, 50))
      Time(1, 0) - Time(1, 0) should be(Time(0, 0))
    }
    "do more fancy tricks" is (pending)
  }

}