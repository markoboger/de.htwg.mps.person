import scala.util.Random

// Singleton with getInstance

class Singleton1 {
  def singletonFunction = println("I am a singleton")
}
object Singleton1 {
  private var instance:Singleton1 = null
  def getInstance:Singleton1= {
    if (instance == null) {
      instance= new Singleton1()
    }
    instance
  }
}
Singleton1.getInstance.singletonFunction


//Singleton with object
object Singleton {
  def singletonFunction = println("I am a singleton")
}

Singleton.singletonFunction


// Factory with AnimalFactory

trait Animal1 {
  def run = println("animal running")
}

private class Dog1 extends Animal {
  override def run: Unit = println("dog running")
}

private class Cat1 extends Animal {
  override def run: Unit = println("cat running")
}

object AnimalFactory {
  def getInstance(kind: String) = kind match {
    case "dog" => new Dog1()
    case "cat" => new Cat1()
  }
}

val dog1 = AnimalFactory.getInstance("dog")
dog1.run


// Factory with Object

trait Animal {
  def run = println("animal running")
}

private class Dog extends Animal {
  override def run: Unit = println("dog running")
}

private class Cat extends Animal {
  override def run: Unit = println("cat running")
}

object Animal {
  def apply(kind: String) = kind match {
    case "dog" => new Dog()
    case "cat" => new Cat()
  }
}

val dog2 = Animal("dog")
dog2.run

// Strategy with Inheritance

object Context1 {

  trait Strategy {
    def execute
  }

  class Strategy1 extends Strategy {
    override def execute = println("I am strategy 1")
  }

  class Strategy2 extends Strategy {
    override def execute = println("I am strategy 2")
  }

  var strategy = if (Random.nextInt() % 2 == 0) new Strategy1 else new Strategy2
}

Context1.strategy.execute

// Strategy with reassignable functions

object Context2 {

  def strategy = if (Random.nextInt() % 2 == 0) strategy1 else strategy2

def strategy1 = println("I am strategy 1")

def strategy2 = println("I am strategy 2")
}

Context2.strategy

// State1
trait Event

case class OnEvent() extends Event

case class OffEvent() extends Event

object StateContext1 {

  trait State {
    def handle(e: Event): State
  }

  case class OnState() extends State {
    println("I am On")

    override def handle(e: Event): State = {
      e match {
        case on: OnEvent => OnState()
        case off: OffEvent => OffState()
      }
    }
  }

  case class OffState() extends State {
    println("I am Off")

    override def handle(e: Event): State = {
      e match {
        case on: OnEvent => OnState()
        case off: OffEvent => OffState()
      }
    }
  }

  var state: State = OffState()

  def handle(e: Event) = state = state.handle(e)
}

StateContext1.handle(new OnEvent)
StateContext1.handle(new OffEvent)

//State2

object StateContext2 {
  var state = onState
  def handle(e: Event) = {
    e match {
      case on: OnEvent => state = onState
      case off: OffEvent => state = offState
    }
    state
  }

  def onState = println("I am on")
  def offState = println("I am off")
}

StateContext2.handle(OnEvent())
StateContext2.handle(OffEvent())



