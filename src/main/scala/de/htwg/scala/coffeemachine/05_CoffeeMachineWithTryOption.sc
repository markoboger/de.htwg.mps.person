import scala.util.{Failure, Random, Success, Try}

trait ConsumerAndProducer[Output]  {
  var fillLevel:Int
  def consume(units:Int = 1, output:Output):Option[Try[Output]] = {
      if (fillLevel >= units) {
        fillLevel = fillLevel - units
        Some(Success(output))
      } else if (fillLevel==0) None
      else Some(Failure(new Exception("Fill level too low")))
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

  def grind: Option[Try[CoffeePowder]] = coffee.consume(output = new CoffeePowder)
  def heatWater: Option[Try[HotWater]] = water.consume(output = new HotWater)
  def foamMilk(milk: MilkBottle): Option[Try[FoamedMilk]] = milk.consume(output = new FoamedMilk)
  def brewEspresso(coffee: Option[Try[CoffeePowder]], heatedWater: Option[Try[HotWater]]): Option[Try[Espresso]] = {
    for ( c <- coffee;
          h <- heatedWater) yield {
      Success(new Espresso)
    }
  }
  def combine(espresso: Option[Try[Espresso]], foamedMilk: Option[Try[FoamedMilk]]): Option[Try[Cappuccino]] = {
    for (e <- espresso;
         f <- foamedMilk) yield {
      Success("This is a Cappuccino")
    }
  }

  def prepareCappuccino: Option[Try[Cappuccino]] = {
    val coffeePowder: Option[Try[CoffeePowder]] = grind
    val hotWater: Option[Try[HotWater]] = heatWater
    val espresso: Option[Try[Espresso]] = brewEspresso(coffeePowder, hotWater)
    val foam: Option[Try[FoamedMilk]] = foamMilk(milk)
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