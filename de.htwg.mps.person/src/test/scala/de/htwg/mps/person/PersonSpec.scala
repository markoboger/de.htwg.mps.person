package de.htwg.mps.person

import scala.collection.Seq
import org.specs2.mutable._

class PersonSpec extends Specification {
  "A Person born on 4th of July in 1971" should {
    val peter = new Person("Peter", new Date(1971, 7, 4))
    
    "be 20 on 3rd of Juli 1992" in {
      peter.age(new Date(1992,7,3)) must be_==(20)
    }
    "be 21 on 4th of Juli 1992" in {
      peter.age(new Date(1992,7,4)) must be_==(21)
    }
    "be 21 on 5th of Juli 1992" in {
      peter.age(new Date(1992,7,5)) must be_==(21)
    }
    
    "be older than a person born in 1973" in {
      val paul = new Person("Paul", new Date(1973, 7,4))
      peter > paul must beTrue
      paul > peter must beFalse
    }
    
    "be younger than a person born in 1969" in {
      val mary = new Person("Mary", new Date(1969, 7,4))
      peter > mary must beFalse
      mary > peter must beTrue
    }
    
  }

}