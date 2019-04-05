
  println("Welcome to the Scala worksheet")
  
  def isEven(x:Int) = x%2==0
  
  
  for {
  	i <- 1 to 4
  	j <- 1 to i
  	if isEven(i+j)
  } yield (i,j)

  
  (1 to 4) flatMap ( i =>
    (1 to i) filter (j => isEven(i+j))
      map (j => (i,j)))

  
  var list = List(1,2,3,4)

	for (i <- list) yield i*i
	
	list.map(i=>i*i)
	
	var pairs = List (List(1,2), List(3,4))
	
	pairs.map(pair => pair.map(int => int*int))

	pairs.flatMap(pair => pair)
	
	pairs.flatMap(pair => pair.map(i=>i*i))


	object BottleState extends Enumeration {
		type BottleState = Value
		val Empty, Labeled, Filled, Capsuled, Consumed = Value
	}
	import BottleState._

	case class Bottle(state: BottleState=Empty) {
		def label: Bottle = copy(state=Labeled)
		def fill:Bottle = copy(state=Filled)
		def capsule:Bottle = copy(state=Capsuled)
		def consume:Bottle = {
			println(" consuming... ")
			copy(Consumed)
		}
	}

	new Bottle().label.fill.capsule


	case class MaybeBottle(bottle:Option[Bottle]) {
		def label : Option[Bottle] = bottle match {
			case Some(bottle:Bottle) => Some(bottle.label)
			case None => None
		}
	}

	val maybBottle = MaybeBottle(Some[new Bottle])
	maybBottle.label

	class Pack(val bottles:List[Bottle]) {
		def map(f:Bottle => Bottle) = bottles.map(bottle => f(bottle))
		override def toString="UUUU"
	}
	
	class Crate(val packs:List[Pack]) {
		def map(f:Pack => Pack) = packs.map(pack => f(pack))
		def flatMap(f:Pack => List[Bottle]) = packs.flatMap(pack => f(pack))
		override def toString="L_____J"
	}
	
	val pack = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle))

	
  pack.map(bottle => bottle.consume)
	for (bottle <- pack.bottles) yield bottle.consume
	
  val pack1 = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle))

	val pack2 = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle))

	val crate1 = new Crate(List(pack1, pack2))
	
	def consumeAll(crate:Crate) = {
		var packs = crate.packs
		packs.foreach {pack =>
			var bottles = pack.bottles
			bottles.foreach { bottle =>
				bottle.consume
			}
		}
	}
	
	consumeAll(crate1)


	def consumeAllWithFor(crate:Crate) = {
	  for (pack <- crate1;
       bottle <- pack) yield bottle.consume
	}
 consumeAllWithFor(crate1)

  val pack3 = new Pack(List(new Bottle, null, new Bottle, new Bottle))

	val pack4 = new Pack(List(new Bottle, new Bottle, null, new Bottle))

	val crate2 = new Crate(List(pack3, pack4))
  
 def consumeAllAssumeNull(crate:Crate) = {
 		if (crate != null) {
 			var packs = crate2.packs
 			if (packs != null) {
 					packs.foreach { pack =>
 						if (pack != null) {
 							var bottles = pack.bottles
 							if (bottles != null) {
 								bottles.foreach { bottle =>
 									if (bottle != null) bottle.consume
 									else println ("Found a null for bottle")
 								}
 							} else println ("Found a null for bottles")
 						} else println ("Found a null for pack")
 					}
 			} else println ("Found a null for packs")
 		}	else println ("Found a null for crate")
 }
 	
 consumeAllAssumeNull(crate2)

/*
trait Option[Bottle] {
	def map(f:Bottle => Bottle):Option[Bottle]
}

case class Some[Bottle](val b:Bottle) extends Option[Bottle] {
	def map(f:Bottle => Bottle) = new Some(f(b))
}

case class None[Bottle]() extends Option[Bottle] {
	def map(f:Bottle => Bottle) = new None
}
*/
class PackT[T](val bottles:List[T]) {
		def map(f:T => T) = bottles.map(bottle => f(bottle))
		override def toString="UUUU"
	}
	
	class CrateT[T](val packs:List[T]) {
		def map(f:T => T) = packs.map(pack => f(pack))
		def flatMap(f:T => List[Bottle]) = packs.flatMap(pack => f(pack))
		override def toString="L_____J"
	}
	
val maybeBottle:Option[Bottle] = Some(new Bottle)
val pack5= new PackT( List(Some(new Bottle), None, Some(new Bottle), Some(new Bottle)))

val pack6= new PackT( List(Some(new Bottle), Some(new Bottle), None, Some(new Bottle)))

val crate3 = new CrateT(List(Some(pack5),Some(pack6)))


def consumeAllAssumeNoneWithFor(pack:PackT[Option[Bottle]]) = {
		for (
		   bottle <- pack.bottles) yield bottle match {
			case Some(b) => b.consume
			case None => println("Found None")
		}
}
consumeAllAssumeNoneWithFor(pack6)
	
