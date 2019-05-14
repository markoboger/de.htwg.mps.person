package de.htwg.scala.temperatureConverter

import org.scalatest.{WordSpec, Matchers}

class CelsiusSpec extends WordSpec with Matchers {

  "An Instance of class Celsius with value 0" should {
    "convert to an instance of class Fahrenheit with value 32" in {
      Celsius(0).toFahrenheit shouldBe Fahrenheit(32)
    }
  }
}

class FahrenheitSpec extends WordSpec with Matchers {

  "An Instance of class Fahrenheit with value 32" should {
    "convert to an instance of class Celsius with value 0" in {
      Fahrenheit(32).toCelsius shouldBe Celsius(0)
    }
  }
}