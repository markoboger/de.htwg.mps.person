trait ConsumerAndProducer[Output]  {
  var fillLevel:Int
  def consume(units:Int = 1, output:Output) = {
    fillLevel = fillLevel-units
    output
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

  def grind: CoffeePowder = coffee.consume(output = new CoffeePowder)
  def heatWater: HotWater = water.consume(output = new HotWater)
  def foamMilk(milk: MilkBottle): FoamedMilk = milk.consume(output = new FoamedMilk)
  def brewEspresso(coffee: CoffeePowder, heatedWater: HotWater): Espresso = new Espresso
  def combine(espresso: Espresso, foamedMilk: FoamedMilk): Cappuccino = "This is a Cappuccino"

  def prepareCappuccino: Cappuccino = {
    val coffeePowder = grind
    val hotWater = heatWater
    val espresso = brewEspresso(coffeePowder, hotWater)
    val foam = foamMilk(milk)
    combine(espresso, foam)
  }
}

object CoffeeMachine {
  val coffee = CoffeeBeanReservoir(10)
  val water = WaterTank(10)
  val milk = MilkBottle(10)
  val machine = new CoffeeMachine(coffee, water, milk)
  def prepareCappuccino = machine.prepareCappuccino
}

CoffeeMachine.prepareCappuccino
CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk

CoffeeMachine.prepareCappuccino
CoffeeMachine.coffee
CoffeeMachine.water
CoffeeMachine.milk