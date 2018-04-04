package de.htwg

import java.net.URL
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object L12_Future {

  def loadTime(host: String) = {
    val url = new URL("http://" + host)
    val start = System.currentTimeMillis()
    url.openConnection()
    url.getContent()
    val end = System.currentTimeMillis()
    end - start
  }                                               //> loadTime: (host: String)Long

  loadTime("www.htwg-konstanz.de")                //> res0: Long = 172
  loadTime("www.google.de")                       //> res1: Long = 78
  
  Future(loadTime("www.spiegel.de"))              //> res2: scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@539e922d
  Future(loadTime("www.htwg-konstanz.de"))        //> res3: scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@8fa0f67
  Future(loadTime("www.google.de"))               //> res4: scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@47b9af7d
  val future1 = Future(loadTime("www.spiegel.de"))//> future1  : scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$Def
                                                  //| aultPromise@16daece7
  future1.onComplete{
  	case Success(time) => println(time)
  	case Failure(e) => println("failed")
  }
  
   var result:Long = 0                            //> result  : Long = 0
  future1.onComplete{
  	case Success(time) => result = time
  	case Failure(e) => println("failed")
  }
  result                                          //> res5: Long = 0
  
  Await.ready(future1, Duration(1000,"millis"))   //> 47
                                                  //| res6: de.htwg.L12_Future.future1.type = scala.concurrent.impl.Promise$Defau
                                                  //| ltPromise@16daece7
  result                                          //> res7: Long = 47
  
}