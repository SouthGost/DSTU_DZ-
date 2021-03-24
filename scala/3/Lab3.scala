object Lab3 {
  //1

  // файлы

  //2

  trait forQueue[T]{
    def add(x:T):Unit
    def del:Unit
    def show:Unit
  }

  class QueueI extends forQueue[Int]{
    private var list: List[Int] = Nil
    private var tail:Any = Nil
    private var head:Any = Nil

    override def add(x:Int):Unit = {
      if(list.isEmpty){
        head=x
      }
      list = list:+x
      tail=x
    }

    override def del:Unit = {
      if(list.nonEmpty){
        list=list.tail
        if(list.nonEmpty){
          head= list(0)
        } else {
          tail = Nil
          head = Nil
        }
      }
    }

    override def show:Unit = {
      for(x<-list){
        println(x)
      }
      println(s"голова ${head}\nхвост ${tail}")
    }
  }

  //3

  trait forList[T]{
    def sum:T
    def mul:T
    def average:Double
  }

  class MyListi(var list:List[Int]) extends forList[Int]{
    override def sum = {
      var summ = 0
      for (x<-list){
        summ+=x
      }
      summ
    }

    override def mul: Int = {
      var mult = 1
      for (x<-list){
        mult*=x
      }
      mult
    }

    override def average: Double = {
      sum/list.length
    }
  }

  def main(args: Array[String]): Unit = {

    /* 1
    Реализовать класс «число в степени». Реализовать в виде трейтов
    возведение в степень 2,3,4,5. Для каждой степени отдельный
    трейт. Подмешать трейт в объект.
    */

//    val p2 = new In2.powI(2)
//    println(p2.rezult)
//    val p3 = new In3.powI(2)
//    println(p3.rezult)
//    val p4 = new In4.powI(2)
//    println(p4.rezult)
//    val p5 = new In5.powI(2)
//    println(p5.rezult)

    /*2
    Реализовать класс очередь. Методы очереди (добавление,
    удаление, вывод) описать отдельными трейтами.
    */

    val q = new QueueI
    q.add(5)
    q.show
    q.add(10)
    q.del
    q.add(1)
    q.add(7)
    q.add(4)
    q.show

    /*3
    Реализовать класс список. С помощью трейтов реализовать
    методы суммирования, произведения, среднего значения
    элементов списка
     */

//    val mylistik = new MyListi(List(1,5,4,3,7))
//    println(mylistik.sum)
//    println(mylistik.mul)
//    println(mylistik.average)

  }
}
