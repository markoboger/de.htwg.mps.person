package de.htwg.scala.person

import org.scalatest.WordSpec
import org.scalatest.Matchers._

import de.htwg.scala.person.Date;
import de.htwg.scala.person.Person;

class PersonSpec extends WordSpec {
  
  "A Person born on 4th of July in 1971" should {
    val peter = new Person("Peter", new Date(1971, 7, 4))
    
    "be 20 on 3rd of Juli 1992" in {
      peter.age(new Date(1992,7,3)) should be(20)
    }
    "be 21 on 4th of Juli 1992" in {
      peter.age(new Date(1992,7,4)) should be(21)
    }
    "be 21 on 5th of Juli 1992" in {
      peter.age(new Date(1992,7,5)) should be(21)
    }
    
    "be older than a person born in 1973" in {
      val paul = new Person("Paul", new Date(1973, 7,4))
      peter > paul should be(true)
      paul > peter should be(false)
    }
    
    "be younger than a person born in 1969" in {
      val mary = new Person("Mary", new Date(1969, 7,4))
      peter > mary should be(false)
      mary > peter should be(true)
    }
    
  }

}