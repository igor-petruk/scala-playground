package playground

import java.util.Date
import scala.math._

object Main {

  def typeInference{
    val i:Int = 1
    val k = 1
    val j = Pi
    val m = new Date
  }
  
  def functionValueVariable{
    def i = 1         // int i() {return 1;}
    val j = 2         // final int j = 2;
    var k = 3         // int k = 3;
    lazy val m = 4    // lazily computed value
  }

  def types{
    val simple = "Test" 
    val tuple = ("String", 10)
    val array = Array(1,2,3)
    val list = List(2.2, 3.0, 4.0)
  }
  
  class NameClass(name:String, country:String="UK"){
     require(name!=null, "Name cannot be null")
     require(name!="", "Name cannot be empty")
     require(country!=null, "Country cannot be null")

     val myName = name(0).toUpper + name.tail

     def this(fileName:String) = {
       // read from file
       this("NameFromFile","")
     }

     def sayHello = "Hello, "+myName
  }

  object ChuckNorris extends NameClass("Chuck","US"){
    def makeEarthTurn{
      println("Do it, Earth")
    }
  }

  def main(args: Array[String]){
    println(new NameClass("igor", "Ukraine").sayHello)
  }

}