object Lab3 {
  //1

  class powr(val osnovanie:Double) extends In2.power with In3.power with In4.power with In5.power{}


  //2

  trait mylistTH{
    var list: List[Int] = Nil
    var tail:Any = Nil
    var head:Any = Nil
  }



  trait forAddInQueue extends mylistTH{

    def add(x:Int):Unit = {
      if(list.isEmpty){
        head=x
      }
      list = list:+x
      tail=x
    }
  }

  trait forDelInQueue extends mylistTH{


    def del:Unit= {
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
  }

  trait forShowInQueue extends mylistTH{

    def show:Unit = {
      for(x<-list){
        println(x)
      }
      println(s"голова ${head}\nхвост ${tail}")
    }
  }

  class Queue extends forAddInQueue with forDelInQueue with forShowInQueue{}

  //3

  trait mylist{
    var list: List[Int]
  }

  trait forListSum extends mylist{
    def sum = {
      var summ = 0
      for (x<-list){
        summ+=x
      }
      summ
    }
  }

  trait forListMul extends mylist{
    def mul = {
      var mult = 1
      for (x<-list){
        mult*=x
      }
      mult
    }

  }

  trait forListAverage extends forListSum{
    def average:Double = {
      sum/list.length
    }
  }

  class MyListi(override var list: List[Int]) extends forListMul with forListAverage{}


  def main(args: Array[String]): Unit = {

    /* 1
    Реализовать класс «число в степени». Реализовать в виде трейтов
    возведение в степень 2,3,4,5. Для каждой степени отдельный
    трейт. Подмешать трейт в объект.
    */

//    val p = new powr(3)
//    println(p.vozvedenie2)
//    println(p.vozvedenie3)
//    println(p.vozvedenie4)
//    println(p.vozvedenie5)

    /*2
    Реализовать класс очередь. Методы очереди (добавление,
    удаление, вывод) описать отдельными трейтами.
    */

//    val q = new Queue
//    q.add(5)
//    q.show
//    q.add(10)
//    q.del
//    q.add(1)
//    q.add(7)
//    q.add(4)
//    q.show

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
