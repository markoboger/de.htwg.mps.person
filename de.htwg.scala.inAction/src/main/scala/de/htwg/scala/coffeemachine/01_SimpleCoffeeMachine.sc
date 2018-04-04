case class CoffeeBeanReservoir(fillLevel:Int)
case class CoffeePowder()
case class WaterTank(fillLevel: Int)
case class HotWater(temp:Int)
type Milk = String
type FrothedMilk = String
type Espresso = String
type Cappuccino = String

def grind(beans: CoffeeBeanReservoir): Option[CoffeePowder] = beans.fillLevel match {
  case level if (level > 0) => Some(CoffeePowder())
  case level if (level <=0) => None
}
def heatWater(water: WaterTank): HotWater = HotWater(temp = 85)
def frothMilk(milk: Milk): FrothedMilk = s"frothed $milk"
def brew(coffee: CoffeePowder, heatedWater: HotWater): Espresso = "espresso"
def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "This is a cappuccino"
// some exceptions for things that might go wrong in the individual steps
// (we'll need some of them later, use the others when experimenting
// with the code):
case class NoCoffeeBeansException(msg: String) extends Exception(msg)
case class FrothingException(msg: String) extends Exception(msg)
case class WaterBoilingException(msg: String) extends Exception(msg)
case class BrewingException(msg: String) extends Exception(msg)
// going through these steps sequentially:
def prepareCappuccino: Cappuccino = {
  val coffeePowder = grind(CoffeeBeanReservoir(10))
  val hotWater = heatWater(WaterTank(10))
  val espresso = brew(coffeePowder.get, hotWater)
  val foam = frothMilk("milk")
  combine(espresso, foam)
}

println(prepareCappuccino)