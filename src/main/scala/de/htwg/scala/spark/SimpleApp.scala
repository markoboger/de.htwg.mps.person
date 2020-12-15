package de.htwg.scala.spark

import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("Simple Application").config("spark.master", "local").getOrCreate()
    val logData = spark.read.textFile("./LICENSE").cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}