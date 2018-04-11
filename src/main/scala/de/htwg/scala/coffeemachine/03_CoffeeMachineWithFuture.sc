import scala.util.{Failure, Random, Success}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

trait ConsumerAndProducer[Output]  {
  var fillLevel:Int
  def consume(units:Int = 1, output:Output):Future[Output] = Future {
    if (fillLevel >= units) {
      fillLevel = fillLevel-units
      output
    } else throw new IllegalStateException()
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

  def grind: Future[CoffeePowder] = coffee.consume(output = new CoffeePowder)
  def heatWater: Future[HotWater] = water.consume(output = new HotWater)
  def foamMilk(milk: MilkBottle): Future[FoamedMilk] = milk.consume(output = new FoamedMilk)
  def brewEspresso(coffee: Future[CoffeePowder], heatedWater: Future[HotWater]): Future[Espresso] = {
    for ( c <- coffee;
          h <- heatedWater) yield {
      new Espresso
    }
  }
  def combine(espresso: Future[Espresso], foamedMilk: Future[FoamedMilk]): Future[Cappuccino] = {
    for (e <- espresso;
         f <- foamedMilk) yield {
      "This is a Cappuccino"
    }
  }

  def prepareCappuccino: Future[Cappuccino] = {
    val coffeePowder: Future[CoffeePowder] = grind
    val hotWater: Future[HotWater] = heatWater
    val espresso: Future[Espresso] = brewEspresso(coffeePowder, hotWater)
    val foam: Future[FoamedMilk] = foamMilk(milk)
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

Await.ready(CoffeeMachine.prepareCappuccino,1.second)
CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk

Await.ready(CoffeeMachine.prepareCappuccino,1.second)
CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk