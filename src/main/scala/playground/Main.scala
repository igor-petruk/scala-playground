package playground

import playground.Main.Settlement

object Main {

  class Settlement{
    var quantity: Int = 0

    var country: String = ""
    var sublocation:String = ""
    
    // A lot of fields
  }

  object BigAmericanTrade{
    def unapply(settlement:Settlement):Option[(Int, String)]={
      import settlement._
      if (country=="US" && quantity>10000)
        Some((quantity, sublocation))   // Let's imagine sublocation is a state name for US
      else
        None
    }
  }
  
  def customExtractorExample{
    val settlement = new Settlement
    settlement.quantity = 50000
    settlement.country = "US"
    settlement.sublocation = "Arizona"

    settlement match {
      case BigAmericanTrade(qtty, state) => {
        println("Big trade in "+state)
      }
      case _ =>
    }
  }
  
  def builtInCaseClassExtractorExample{
    // case class
    case class MyObject(name:String)

    MyObject("test") match {
      // value
      case MyObject("value")=>
      // with guards
      case MyObject(myName) if (myName.size>0) =>
      // variable
      case MyObject(variable) =>
    }
  }

  def builtInRegexExtractorExample{
    val Email= "^(.+)[@](.+)$".r
    val converted = "igor.petrouk@gmail.com" match {
      case Email(user, domain) => user+"[et]"+domain
      case other:String => other
    }
    println(converted)
  }

  def main(args: Array[String]){
    builtInRegexExtractorExample
  }

}