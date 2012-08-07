package playground

object Main {

  def typeConversion{
    class Person(fName:String){
      val name = fName
    }

    implicit def person2String(person:Person) = "Person(%s)".format(person.name)

    var stringified:String = "Hello";
    stringified = new Person("John")
  }
  
  def autoDecorators{

    class Writable[T](value:T){
      def write{
        println("Wrote "+value)
      }
    }
    
    implicit def anything2Writable[T](value: T) = new Writable(value)

    "Cookie".write
    2.write
  }

  def autoDecoratorsShorter{

    implicit def anything2Writable[T](value: T) = new {
      def write{
        println("Wrote "+value)
      }
    }

    "That works too".write
  }  

  object MyDatabase{
    class Database
    implicit val connection = new Database
  }

  def implicitParameters{
    import MyDatabase._

    def query(sql:String)(implicit c:Database)={
      "Result of sql"  
    }
    
    val result = query("select something")
    println(result)
  }
  
  def main(args: Array[String]){
    println("Welcome Scala")
  }

}