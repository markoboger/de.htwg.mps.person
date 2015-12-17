package de.htwg.mps.time

case class ScalaTime(hours: Int = 0, minutes: Int = 0) {
  
  val hour=hours%24 + minutes/60
  val min=minutes%60
  val asMinutes = hours * 60 + minutes
  
  def +(that: ScalaTime) = ScalaTime(this.hours + that.hours, this.minutes + that.minutes)
  def -(that: ScalaTime) = ScalaTime(minutes = this.asMinutes + that.asMinutes)

  override def toString = f"$hour%02d:$min%02d"

  
}