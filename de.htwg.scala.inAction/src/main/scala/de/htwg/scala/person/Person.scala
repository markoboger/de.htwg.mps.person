package de.htwg.scala.person

case class Person(name:String, birthdate:Date) extends Ordered[Person]{
  override def compare(that: Person) = this.age - that.age
  def age = birthdate.fullYearsSince
  def age(date:Date) = birthdate.fullYearsSince(date)
}