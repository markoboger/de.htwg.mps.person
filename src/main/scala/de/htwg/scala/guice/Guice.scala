package de.htwg.scala.guice

import com.google.inject.{AbstractModule, Guice, Inject}
import net.codingwell.scalaguice.ScalaModule

trait Payment {
  def pay
}

class PaymentInCash extends Payment {
  override def pay = println("I am paying with cash")
}

class PaymentWithCard extends Payment {
  override def pay = println("Here is my credit card")
}

class Order @Inject() (payment: Payment){
  def handleOrder: Unit = {
    payment.pay
  }
}

class OrderModule extends AbstractModule with ScalaModule {
  def configure(): Unit = {
    bind[Payment].to[PaymentWithCard]
  }
}

import net.codingwell.scalaguice.InjectorExtensions._

object OrderServer {
  def main(args: Array[String]) {
    val injector = Guice.createInjector(new OrderModule())

    val orderService = injector.instance[Order]
    orderService.handleOrder
  }
}
