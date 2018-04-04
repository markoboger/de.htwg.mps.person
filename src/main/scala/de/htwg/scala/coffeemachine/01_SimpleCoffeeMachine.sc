import scala.util.Random

case class CoffeeBeanReservoir(fillLevel:Int)
case class WaterTank(fillLevel: Int)
case class MilkBottle(fillLevel:Int)

case class CoffeeMachine(coffee:CoffeeBeanReservoir, water:WaterTank, milk:MilkBottle){

  class CoffeePowder
  case class HotWater(temp:Int)
  class Milk
  class FoamedMilk
  class Espresso
  type Cappuccino = String

  class NoCoffeeBeansException(msg: String) extends Exception(msg)
  class NoMilkException(msg: String) extends Exception(msg)
  class NoWaterException(msg: String) extends Exception(msg)

  def grind(beans: CoffeeBeanReservoir): Option[CoffeePowder] = beans.fillLevel match {
    case level if (level > 0) => Some(new CoffeePowder)
    case level if (level <=0) => None
  }
  def heatWater(water: WaterTank): HotWater = HotWater(temp = 85)
  def foamMilk(milk: Milk): FoamedMilk = new FoamedMilk
  def brew(coffee: CoffeePowder, heatedWater: HotWater): Espresso = new Espresso
  def combine(espresso: Espresso, frothedMilk: FoamedMilk): Cappuccino = "This is a Cappuccino"

  def prepareCappuccino: Cappuccino = {
    val coffeePowder = grind(CoffeeBeanReservoir(10))
    val hotWater = heatWater(WaterTank(10))
    val espresso = brew(coffeePowder.get, hotWater)
    val foam = foamMilk(new Milk)
    combine(espresso, foam)
  }
}

object CoffeeMachine {
  val coffee = CoffeeBeanReservoir(Random.nextInt(10))
  val water = WaterTank(10)
  val milk = MilkBottle(10)
  val machine = new CoffeeMachine(coffee, water, milk)
}

println(CoffeeMachine.machine.prepareCappuccino)