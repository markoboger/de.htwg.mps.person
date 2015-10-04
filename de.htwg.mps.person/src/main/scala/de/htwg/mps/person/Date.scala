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
  def fullYearsSince(that: Date): Int = if (this <= that) {
    if (this.anniversary <= that.anniversary) that.year - year else that.year - year - 1
  } else 0
  def fullYearsSince: Int = fullYearsSince(Today.date)
  override def toString = year + "-" + month + "-" + day
}
