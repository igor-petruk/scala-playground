package playground

import java.io.{FileOutputStream, PrintWriter}

object Main {

  def using[T <: {def close():Unit},R](value:T)(f: T=>R):R={
    try{
      f(value)
    }finally{
      value.close
    }  
  }
  
  def main(args: Array[String]){
    using(new PrintWriter(new FileOutputStream("test"))){file=>
      file.println("Hello")
    }
  }

}