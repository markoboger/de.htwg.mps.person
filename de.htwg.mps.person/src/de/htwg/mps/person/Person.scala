package de.htwg.mps.person

class Person(val name:String, val birthdate:Date) extends Ordered[Person]{
  override def compare(that: Person) = {
    if (this.age < that.age) -1 else if (this.age > that.age) 1 else 0
  }
  def age = birthdate.fullYearsSince
  def age(date:Date) = birthdate.fullYearsSince(date)
}