package de.htwg.scala.spark

import de.htwg.scala.kafka.Consumer.consumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

import collection.JavaConverters.asJavaCollection
import scala.collection.JavaConverters._
import org.apache.kafka.common.TopicPartition

object SparkStream {
  def main(args:Array[String]):Unit = {
    val spark = SparkSession.builder.appName("Spark Streaming").config("spark.master", "local").getOrCreate()

    val scalaKafkaParams = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "use_a_separate_group_id_for_each_stream",
    "auto.offset.reset" -> "latest",
    "enable.auto.commit" -> (false: java.lang.Boolean)
    )
    val kafkaParams=scalaKafkaParams.asJava
    val sc = new StreamingContext(spark.sparkContext, Seconds(1))

    val topics = asJavaCollection(Array("topicA", "topicB"))
    val offset = Map[TopicPartition, java.lang.Long]((new TopicPartition("partition",1),1L)).asJava

    val stream = KafkaUtils.createDirectStream[String, String](sc, PreferConsistent, Subscribe[String, String](topics, kafkaParams, offset))

    stream.foreachRDD(rdd => println( "RDD" + rdd.toString()))

    spark.stop()
  }
}