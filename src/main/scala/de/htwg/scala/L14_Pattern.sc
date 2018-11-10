
import scala.util.Random._

object L14_Pattern {

  // Singleton

  object Singleton {
    def singletonFunction = println("I am a singleton")
  }

  Singleton.singletonFunction

  // Strategy1

  object StrategyContext1 {
    trait Strategy {
      def execute
    }
    class Strategy1 extends Strategy {
      override def execute = println("I am strategy 1")
    }
    class Strategy2 extends Strategy {
      override def execute = println("I am strategy 2")
    }
    var strategy = if (scala.util.Random.nextInt() % 2 == 0) new Strategy1 else new Strategy2
  }

  StrategyContext1.strategy.execute

  // Strategy2

  object Context2 {

    def strategy = if (scala.util.Random.nextInt() % 2 == 0) strategy1 else strategy2

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
    def handle(e: Event) = e match {
      case on: OnEvent => println("I am on")
      case off: OffEvent => println("I am off")
    }
  }

  StateContext2.handle(OnEvent())
  StateContext2.handle(OffEvent())

  // Factory

  trait Animal
  private class Dog extends Animal
  private class Cat extends Animal

  object Animal {
    def apply(kind: String) = kind match {
      case "dog" => new Dog()
      case "cat" => new Cat()
    }
  }

  Animal("dog")

}