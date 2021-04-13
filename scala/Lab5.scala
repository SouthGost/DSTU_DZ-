

trait Worker{
    val name:String
    val age:Int
  }

  case object  Director extends Worker {
    val position = "Director"
    override val name: String = _
    override val age: Int = _
  }

  case object  Manager extends Worker{
    val position = "Manager"
    override val name: String = _
    override val age: Int = _
  }

  case object  Cleaner extends Worker{
    val position = "Cleaner"
    override val name: String = _
    override val age: Int = _
  }

  def printWorkerSalary(worker:Worker): Unit ={
    worker match{
      case Director => println(100_000)
      case Manager => println(50_000)
      case Cleaner => println(10_000)
    }
  }

  def main(args: Array[String]): Unit = {
    val DlgDirector = new Director("Yriy",30);
    val DlgManager = new Director("Kristina",30);
    val DlgCleaner = new Director("Pasha",30);
  }