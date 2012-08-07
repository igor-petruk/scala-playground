package playground

import playground.Main.NumberHolder

object Main {

  trait OddEven{
    def odd:Boolean
    def even = !odd
  }

  trait Value{
    def value:Int
  }

  trait ByTwo extends Value{
    def even: Boolean
    def byTwo = if (even) value/2 else sys.error("Oops")
  }
  
  class NumberHolder(fValue:Int) extends OddEven with ByTwo{
    def odd = value % 2 != 0
    def value = fValue
  }

  trait LoggedValue extends Value{
    abstract override def value:Int={
      println("Logged %d".format(super.value))
      super.value
    }
  }

  def main(args: Array[String]){
    val nh = new NumberHolder(10) with LoggedValue
    println(nh.byTwo)
  }

}