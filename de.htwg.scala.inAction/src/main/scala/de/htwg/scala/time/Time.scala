package de.htwg.scala.time

case class Time(hours: Int = 0, minutes: Int = 0) {

  val HoursPerDay = 24;
  val MinutesPerHour = 60;

  val hour = hours % HoursPerDay + minutes / MinutesPerHour
  val min = minutes % MinutesPerHour
  val asMinutes = hours * MinutesPerHour + minutes

  def +(that: Time) = Time(this.hours + that.hours, this.minutes + that.minutes)
  def -(that: Time): Time = if (this.asMinutes >= that.asMinutes)
    Time(minutes = this.asMinutes - that.asMinutes)
  else this + Time(HoursPerDay) - that

  override def toString = f"$hour%02d:$min%02d"

  override def equals(other: Any) = other match {
    case that: Time if (this.getClass == that.getClass) =>
      this.hour == that.hour && this.min == that.min
    case _ => false
  }
}
