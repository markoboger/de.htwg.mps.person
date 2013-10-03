package de.htwg.mps.person

import com.github.nscala_time.time.Imports.DateTime

object Today {
  def now = DateTime.now
  def year = now.getYear
  def month = now.getMonthOfYear()
  def day = now.getDayOfMonth()
  def date = new Date(year, month, day)
}

trait Ordered[A] {
  def compare(that: A): Int
  def <(that: A): Boolean = (this compare that) < 0
  def >(that: A): Boolean = (this compare that) > 0
  def <=(that: A): Boolean = (this compare that) <= 0
  def >=(that: A): Boolean = (this compare that) >= 0
}

class Date(val year: Int, val month: Int, val day: Int) extends Ordered[Date] {
  override def compare(that: Date) = {
    if (this.year != that.year) this.year - that.year
    else if (this.month != that.month) this.month - that.month
    else this.day - that.day
  }
  def anniversary(nth: Int) = new Date(year + nth, month, day)
  def anniversary = new Date(Today.year, month, day)
  def fullYearsSince(date: Date): Int = if (this <= date) {
    if (this.anniversary <= date.anniversary) date.year - year else date.year - year - 1
  } else 0
  def fullYearsSince: Int = fullYearsSince(Today.date)
}
