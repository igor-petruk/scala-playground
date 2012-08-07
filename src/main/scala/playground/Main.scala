package playground

object Main {

  // Algebraic data types
  sealed abstract class Message
  case class StartServer(port:Int) extends Message
  case class TextMessage(value:String) extends Message
  object StopServer extends Message

  def processMessage(msg:Message){
    msg match {
      case StartServer(port) => println("Starting server on port %d".format(port))
      case TextMessage(message) => println("Got %s".format(message))
      case StopServer => println("Shutdown")
    }
  }
  
  def options{
    val optionHasValue:Option[String] = Some("Value") // Has value
    val optionHasNoValue:Option[String] = None  // No value, singleton
    
    val opt = Option(10)
    
    for (value<-opt){
      println("Do something with "+value)
    }
    
    val result = for (value<-opt) yield {
      println("Compute and return")
      value*10
    }
    
    for (i<-Some(1); j<-None){
      println(i+" "+j)
      // not evaluated
    }

    for (i<-Some(1); j<-None) yield {
      i+j
      // combined to None, failed computation
    }
    
    opt.get // throws NoSuchElementException 
    opt.getOrElse(1)
    opt.orElse(Option(2)).get
    opt.orNull
    
    opt.map(_-5)
    
    var list = List[Int]()
    list ++= opt
  }

  def main(args: Array[String]){

  }

}