package de.htwg

object L10_Monads {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def isEven(x:Int) = x%2==0                      //> isEven: (x: Int)Boolean
  
  
  for {
  	i <- 1 to 4
  	j <- 1 to i
  	if isEven(i+j)
  } yield (i,j)                                   //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,2
                                                  //| ), (3,1), (3,3), (4,2), (4,4))
  
  (1 to 4) flatMap ( i =>
    (1 to i) filter (j => isEven(i+j))
      map (j => (i,j)))                           //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,2
                                                  //| ), (3,1), (3,3), (4,2), (4,4))
  
  var list = List(1,2,3,4)                        //> list  : List[Int] = List(1, 2, 3, 4)

	for (i <- list) yield i*i                 //> res2: List[Int] = List(1, 4, 9, 16)
	
	list.map(i=>i*i)                          //> res3: List[Int] = List(1, 4, 9, 16)
	
	var pairs = List (List(1,2), List(3,4))   //> pairs  : List[List[Int]] = List(List(1, 2), List(3, 4))
	
	pairs.map(pair => pair.map(int => int*int))
                                                  //> res4: List[List[Int]] = List(List(1, 4), List(9, 16))
	pairs.flatMap(pair => pair)               //> res5: List[Int] = List(1, 2, 3, 4)
	
	pairs.flatMap(pair => pair.map(i=>i*i))   //> res6: List[Int] = List(1, 4, 9, 16)
	
	
	class Bottle {
	  var empty=false
		def consume = {
			println(" consuming... ")
			empty = true
			this
		}
		override def toString= if (empty) "b" else "B"
	}
	
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
                                                  //> pack  : de.htwg.L10_Monads.Pack = UUUU
	
  pack.map(bottle => bottle.consume)              //>  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //| res7: List[de.htwg.L10_Monads.Bottle] = List(b, b, b, b)
	
	for (bottle <- pack.bottles) yield bottle.consume
                                                  //>  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //| res8: List[de.htwg.L10_Monads.Bottle] = List(b, b, b, b)
	
	
	
  val pack1 = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle))
                                                  //> pack1  : de.htwg.L10_Monads.Pack = UUUU
	val pack2 = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle))
                                                  //> pack2  : de.htwg.L10_Monads.Pack = UUUU
	val crate1 = new Crate(List(pack1, pack2))//> crate1  : de.htwg.L10_Monads.Crate = L_____J
	
	def consumeAll(crate:Crate) = {
		var packs = crate.packs
		packs.foreach {pack =>
			var bottles = pack.bottles
			bottles.foreach { bottle =>
				bottle.consume
			}
		}
	}                                         //> consumeAll: (crate: de.htwg.L10_Monads.Crate)Unit
	
	consumeAll(crate1)                        //>  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
	def consumeAllWithFor(crate:Crate) = {
	  for (pack <- crate1;
       bottle <- pack) yield bottle.consume
	}                                         //> consumeAllWithFor: (crate: de.htwg.L10_Monads.Crate)List[de.htwg.L10_Monads
                                                  //| .Bottle]
 consumeAllWithFor(crate1)                        //>  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //| res9: List[de.htwg.L10_Monads.Bottle] = List(b, b, b, b, b, b, b, b)
       
  val pack3 = new Pack(List(new Bottle, null, new Bottle, new Bottle))
                                                  //> pack3  : de.htwg.L10_Monads.Pack = UUUU
	val pack4 = new Pack(List(new Bottle, new Bottle, null, new Bottle))
                                                  //> pack4  : de.htwg.L10_Monads.Pack = UUUU
	
	val crate2 = new Crate(List(pack3, pack4))//> crate2  : de.htwg.L10_Monads.Crate = L_____J
	//for (pack <- crate2;
  //     bottle <- pack) yield bottle.cleans
  
 
   
  
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
 }                                                //> consumeAllAssumeNull: (crate: de.htwg.L10_Monads.Crate)Unit
 	
 consumeAllAssumeNull(crate2)                     //>  consuming... 
                                                  //| Found a null for bottle
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //| Found a null for bottle
                                                  //|  consuming... 
/*
trait Option[Bottle] {
	def map(f:Bottle => Bottle):Option[Bottle]
	def cleans
}

case class Some[Bottle](val b:Bottle) extends Option[Bottle] {
	def map(f:Bottle => Bottle) = new Some(f(b))
}

case class None[Bottle] extends Option[Bottle] {
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
	
val maybeBottle:Option[Bottle] = Some(new Bottle) //> maybeBottle  : Option[de.htwg.L10_Monads.Bottle] = Some(B)
val pack5= new PackT( List(Some(new Bottle), None, Some(new Bottle), Some(new Bottle)))
                                                  //> pack5  : de.htwg.L10_Monads.PackT[Option[de.htwg.L10_Monads.Bottle]] = UUUU
                                                  //| 
val pack6= new PackT( List(Some(new Bottle), Some(new Bottle), None, Some(new Bottle)))
                                                  //> pack6  : de.htwg.L10_Monads.PackT[Option[de.htwg.L10_Monads.Bottle]] = UUUU
                                                  //| 
val crate3 = new CrateT(List(Some(pack5),Some(pack6)))
                                                  //> crate3  : de.htwg.L10_Monads.CrateT[Some[de.htwg.L10_Monads.PackT[Option[de
                                                  //| .htwg.L10_Monads.Bottle]]]] = L_____J


def consumeAllAssumeNullWithFor(pack:PackT[Option[Bottle]]) = {
		for (
		   bottle <- pack.bottles) yield bottle match {
			case Some(b) => b.consume
			case None => println("Found None")
		}
		
}                                                 //> consumeAllAssumeNullWithFor: (pack: de.htwg.L10_Monads.PackT[Option[de.htwg
                                                  //| .L10_Monads.Bottle]])List[Any]
consumeAllAssumeNullWithFor(pack5)                //>  consuming... 
                                                  //| Found None
                                                  //|  consuming... 
                                                  //|  consuming... 
                                                  //| res10: List[Any] = List(b, (), b, b)
	
}