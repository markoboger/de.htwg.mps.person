package de.htwg.mps.person

class Person(val name:String, val birthdate:Date){
  def age = birthdate.fullYearsSince
  def age(date:Date) = birthdate.fullYearsSince(date)
}