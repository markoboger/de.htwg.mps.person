import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success, Try}

trait ConsumerAndProducer[Output]  {
  var fillLevel:Int
  def consume(units:Int = 1, output:Output):Try[Output] = {
      if (fillLevel >= units) {
        fillLevel = fillLevel - units
        Success(output)
      } else Failure(new Exception("Fill level too low"))
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

  def grind: Try[CoffeePowder] = coffee.consume(output = new CoffeePowder)
  def heatWater: Try[HotWater] = water.consume(output = new HotWater)
  def foamMilk(milk: MilkBottle): Try[FoamedMilk] = milk.consume(output = new FoamedMilk)
  def brewEspresso(coffee: Try[CoffeePowder], heatedWater: Try[HotWater]): Try[Espresso] = {
    for ( c <- coffee;
          h <- heatedWater) yield {
      new Espresso
    }
  }
  def combine(espresso: Try[Espresso], foamedMilk: Try[FoamedMilk]): Try[Cappuccino] = {
    for (e <- espresso;
         f <- foamedMilk) yield {
      "This is a Cappuccino"
    }
  }

  def prepareCappuccino: Try[Cappuccino] = {
    val coffeePowder: Try[CoffeePowder] = grind
    val hotWater: Try[HotWater] = heatWater
    val espresso: Try[Espresso] = brewEspresso(coffeePowder, hotWater)
    val foam: Try[FoamedMilk] = foamMilk(milk)
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