import scala.concurrent.Future
import scala.util.{Failure, Random, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global


trait ConsumerAndProducer[Output]  {
  var fillLevel:Int
  def consume(units:Int = 1, output:Output):Future[Option[Try[Output]]] = {
      if (fillLevel >= units) {
        fillLevel = fillLevel - units
        Future.successful(Some(Success(output)))
      } else if (fillLevel==0) Future.successful(None)
      else Future.successful(Some(Failure(new Exception("Fill level too low"))))
  }
}

class CoffeePowder
class HotWater
class FoamedMilk
class Espresso
type Cappuccino = String

case class CoffeeBeanReservoir(var fillLevel:Int) extends ConsumerAndProducer[CoffeePowder]
case class WaterTank(var fillLevel: Int) extends ConsumerAndProducer[HotWater]
case class MilkBottle(var fillLevel:Int) extends ConsumerAndProducer[FoamedMilk]

case class CoffeeMachine(coffee:CoffeeBeanReservoir, water:WaterTank, milk:MilkBottle){

  def grind: Future[Option[Try[CoffeePowder]]] = coffee.consume(output = new CoffeePowder)
  def heatWater: Future[Option[Try[HotWater]]] = water.consume(output = new HotWater)
  def foamMilk(milk: MilkBottle): Future[Option[Try[FoamedMilk]]] = milk.consume(output = new FoamedMilk)
  def brewEspresso(coffee: Future[Option[Try[CoffeePowder]]], heatedWater: Future[Option[Try[HotWater]]]): Future[Option[Try[Espresso]]] = {
    for ( c <- coffee;
          h <- heatedWater) yield {
      Some(Success(new Espresso))
    }
  }
  def combine(espresso: Future[Option[Try[Espresso]]], foamedMilk: Future[Option[Try[FoamedMilk]]]): Future[Option[Try[Cappuccino]]] = {
    for (e <- espresso;
         f <- foamedMilk) yield {
      Some(Success("This is a Cappuccino"))
    }
  }

  def prepareCappuccino: Future[Option[Try[Cappuccino]]] = {
    val coffeePowder: Future[Option[Try[CoffeePowder]]] = grind
    val hotWater: Future[Option[Try[HotWater]]] = heatWater
    val espresso: Future[Option[Try[Espresso]]] = brewEspresso(coffeePowder, hotWater)
    val foam: Future[Option[Try[FoamedMilk]]] = foamMilk(milk)
    combine(espresso, foam)
  }
}

object CoffeeMachine {
  val coffee = CoffeeBeanReservoir(Random.nextInt(10))
  val water = WaterTank(Random.nextInt(10))
  val milk = MilkBottle(Random.nextInt(10))
  val machine = new CoffeeMachine(coffee, water, milk)
  def prepareCappuccino = machine.prepareCappuccino
}

CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk

CoffeeMachine.prepareCappuccino
CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk

CoffeeMachine.prepareCappuccino
CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk