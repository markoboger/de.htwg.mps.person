import scala.util.Random

trait ConsumerAndProducer[Output]  {
  var fillLevel:Int
  def consume(units:Int = 1, output:Output):Option[Output] = {
    if (fillLevel >= units) {
      fillLevel = fillLevel-units
      Some(output)
    } else None
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

  def grind: Option[CoffeePowder] = coffee.consume(output = new CoffeePowder)
  def heatWater: Option[HotWater] = water.consume(output = new HotWater)
  def foamMilk(milk: MilkBottle): Option[FoamedMilk] = milk.consume(output = new FoamedMilk)
  def brewEspresso(coffee: Option[CoffeePowder], heatedWater: Option[HotWater]): Option[Espresso] = {
    for ( c <- coffee;
          h <- heatedWater) yield {
      new Espresso
    }
  }
  def combine(espresso: Option[Espresso], foamedMilk: Option[FoamedMilk]): Option[Cappuccino] = {
    for (e <- espresso;
         f <- foamedMilk) yield {
      "This is a Cappuccino"
    }
  }

  def prepareCappuccino: Option[Cappuccino] = {
    val coffeePowder: Option[CoffeePowder] = grind
    val hotWater: Option[HotWater] = heatWater
    val espresso: Option[Espresso] = brewEspresso(coffeePowder, hotWater)
    val foam: Option[FoamedMilk] = foamMilk(milk)
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