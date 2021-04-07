object Lab4 {

  def f(x:Double):Double = {
    x match {
      case in(x,0,1) => x
      case (x>=1 && x<2) => 2-x
      case {
        if(x>=2 && x<3)
          x
        else
          x+1
      } => -4+2*x
      case _ => null
    }
  }

/*
Переменной k присвоить номер четверти плоскости, в которой
находится точка с координатами x и y (x, y ≠ 0)
*/

  def What4rt(x:Double,y:Double):String = {
    x match {
      case x>0 => y match {
        case y>0 => "1"
        case y<0 => "2"
      }
      case x<0 => y match {
        case y>0 => "3"
        case y<0 => "4"
      }
      case _ => null
    }
  }

  def main(args: Array[String]): Unit = {
    println(What4rt(3,3));
  }
}
