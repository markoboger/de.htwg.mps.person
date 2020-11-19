package de.htwg.scala.temperatureConverter

case class  Fahrenheit(value:Double) {
  def toCelsius:Celsius = Celsius((value-32)*5/9)
}
case class Celsius(value:Double) {
  def toFahrenheit: Fahrenheit = Fahrenheit((value *9/5) + 32)
}
