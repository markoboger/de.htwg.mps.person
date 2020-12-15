
name := """de.htwg.scala.inAction"""

version := "1.0"

scalaVersion := "2.12.7"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

libraryDependencies += "org.typelevel" %% "spire" % "0.14.1"

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.20.0"

libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.12" % "2.0.3"

libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"

libraryDependencies += "junit" % "junit" % "4.12" % Test

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "11-R16"

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m =>
  "org.openjfx" % s"javafx-$m" % "11" classifier osName
)

val akkaVersion = "2.6.5"

libraryDependencies ++= Seq(
  // akka streams
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
)

//libraryDependencies += "org.apache.kafka" %% "kafka" % "2.6.0"

libraryDependencies += "org.apache.spark" % "spark-core_2.12" % "3.0.1"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.12" % "3.0.1" % "provided"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.12" % "3.0.1"
libraryDependencies += "org.apache.spark" % "spark-sql_2.12" % "3.0.1"
