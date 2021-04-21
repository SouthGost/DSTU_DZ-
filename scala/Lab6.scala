import scala.collection.mutable.ArrayBuffer

object Lab6 {


  def each  (array:ArrayBuffer[Int]):(Unit) => Any  =  (Unit) => {
    if (array.isEmpty){
      println("Массив пуст")
      Nil
    }else {
      array.remove(0)
    }
  }

  def main(args: Array[String]): Unit = {
    var a:ArrayBuffer[Int] = ArrayBuffer(12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    val f = each(a)
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    a = ArrayBuffer(12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23)
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
    println(f())
  }

}
