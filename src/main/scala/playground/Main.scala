package playground

object Main {

  def benchmark(f: =>Unit){
    val start = System.currentTimeMillis
    println("Started at %d".format(start))
    f
    val ended = System.currentTimeMillis()
    println("Ended at %d".format(ended))
    println("Total time %d".format(ended-start))
  }
  
  implicit def simpleIntPowerMaker(value:Int)=new{
    def **(power:Int):Int = {
      var p = 1
      for (i<-1 to power){
        p*=value
      }
      p
    }
  }

  implicit def awesomePowerMaker[T](value:T)(implicit n:Numeric[T])=new{
    def ***(power:Int):T = (1 to power).foldLeft(n.fromInt(1))((acc,v)=>n.times(acc,value))
  }
  
  def main(args: Array[String]){
    benchmark {
      val m = 10 ** 4
      println(m)
    }
  }

}