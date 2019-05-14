
case class  Fahrenheit(value:Double) {
  def toCelsius:Celsius = Celsius((value-32)*5/9)
}
case class Celsius(value:Double) {
  def toFahrenheit: Fahrenheit = Fahrenheit((value *9/5) + 32)
}

val celsius = Celsius(0)
val fahrenheit = Fahrenheit(32)


celsius.toFahrenheit
fahrenheit.toCelsius

Celsius(0).toFahrenheit
Fahrenheit(32).toCelsius


