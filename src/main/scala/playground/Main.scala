package playground

object Main {
  case class Apple(size:Int)
  
  trait AppleEaterComponentApi{
    def eater: AppleEater

    trait AppleEater{
      def eat
    }
  }
  
  trait AppleProducerComponentApi{
    def producer: AppleProducer
    
    trait AppleProducer{
      def produce:Apple
    }
  }
  
  trait WormComponent extends AppleEaterComponentApi{
    self: AppleProducerComponentApi =>
    
    lazy val eater = new AppleEater{
      def eat{
        val apple = producer.produce
        println("Eating "+apple)
      }
    }
  }

  trait AppleTreeComponent extends AppleProducerComponentApi{
    lazy val producer = new AppleProducer {
      def produce = Apple(10)
    }
  }  
  
  def main(args: Array[String]){
    val core = new AppleTreeComponent with WormComponent
    core.eater.eat
  }

}