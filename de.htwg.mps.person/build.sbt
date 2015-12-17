name := """de.htwg.scala.inAction"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.2.0"

scalacOptions in Test ++= Seq("-Yrangepos")

fork in run := true