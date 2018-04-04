package de.htwg.scala.time

case class Time(hours: Int = 0, minutes: Int = 0) {
  import Time._
  val normHours = hours % HoursPerDay + minutes / MinutesPerHour
  val normMinutes = minutes % MinutesPerHour
  val asMinutes = hours * MinutesPerHour + minutes

  def +(that: Time) = Time(this.hours + that.hours, this.minutes + that.minutes)
  def -(that: Time): Time = if (this.asMinutes >= that.asMinutes)
    Time(minutes = this.asMinutes - that.asMinutes)
  else this + Time(HoursPerDay) - that

  override def toString = f"$normHours%02d:$normMinutes%02d"

  override def equals(other: Any) = other match {
    case that: Time if (this.getClass == that.getClass) =>
      this.normHours == that.normHours && this.normMinutes == that.normMinutes
    case _ => false
  }
}

object Time {
  val HoursPerDay = 24;
  val MinutesPerHour = 60;
  def main(args: Array[String]) = {
    val start = Time(8, 40)
    println("The meeting will start at " + start + ".")
    val end = start + Time(0, 20)
    println("The meeting will end at " + end)
  }
}
