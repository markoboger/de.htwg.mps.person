package de.htwg.mps.time

case class ScalaTime(hours: Int = 0, minutes: Int = 0) {
  
  val hour=hours%24 + minutes/60
  val min=minutes%60

  override def toString = f"$hour%02d:$min%02d"

  def +(that: ScalaTime) = ScalaTime(this.hours + that.hours, this.minutes + that.minutes)
}