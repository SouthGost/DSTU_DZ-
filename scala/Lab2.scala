import scala.collection.mutable.ArrayBuffer

object Lab2 {

  class building(val adres: String){
    var garden: Array[String] = Array();
    println("create building")


    def plantFlower(flower: String): Unit = {
      garden = garden:+ flower;
      ()
    }

    def showInf(): Unit ={
      println("building ")
      println("adres: "+ adres)
      println("garden:");
      for (flower <- garden){
        println("\t"+flower);
      }
      println();
      ()
    }
  }

  class manyLevelBuilding(override val adres: String, val level: Byte) extends building(adres){
    println("create many level building")

    override def showInf(): Unit ={
      println("many level building ")
      println("adres: "+ adres)
      println("levels: "+ level)
      println("garden:");
      for (flower <- garden){
        println("\t"+flower);
      }
      println();
      ()
    }
  }

  class room(val square: Double){
    println("create room")

    def showInf(): Unit ={
      println("room ")
      println("square: "+ square)
      println();
    }
  }

  class kitchen(override val square: Double, val sewerPipe: Byte) extends room(square){
    println("create kitchen")
    var furnits:Array[furniture] = Array();

    def addFurnit(furnit: furniture): Unit = {
      furnits = furnits:+ furnit;
      ()
    }

    override def showInf(): Unit ={
      println("kitchen ")
      println("square: "+ square)
      println("sewer pipe: "+ sewerPipe)
      println("furnitures:");
      for (furnit <- furnits){
        furnit.showInf();
      }
      println();
    }
  }

  class furniture(val material: String){
    println("create furniture")

    def showInf(): Unit ={
      println("\tfurniture ")
      println();
    }

  }

  class lamp(override val material: String) extends furniture(material){
    println("create lamp")
    var turn=false;

    def useLamp(){
      turn = !turn;
    }

    override def showInf(): Unit ={
      println("\tLamp ")
      println("\tmaterial: "+ material)
      println("\tturn: "+ turn)
      println();
    }
  }

  class chair(override val material: String, length:Double) extends furniture(material){
    println("create chair")

    override def showInf(): Unit ={
      println("\tchair ")
      println("\tmaterial: "+ material)
      println("\tlength: "+ length)
      println();
    }
  }

  class fridge(override val material: String) extends furniture(material){
    var turn=false;
    println("create fridge")

    def useFridge(){
      turn = !turn;
    }

    override def showInf(): Unit ={
      println("\tfridge ")
      println("\tmaterial: "+ material)
      println("\tturn: "+ turn)
      println();
    }
  }

  class window(override val material: String) extends furniture(material){
    var open = false;
    println("create window")

    def moveWindow(){
      open = !open;
    }

    override def showInf(): Unit ={
      println("\twindow ")
      println("\tmaterial: "+ material)
      println("\topen: "+ open)
      println();
    }
  }

  class door(override val material: String) extends furniture(material){
    var open = false;
    println("create door")

    def moveDoor(){
      open = !open;
    }

    override def showInf(): Unit ={
      println("\tdoor ")
      println("\tmaterial: "+ material)
      println("\topen: "+ open)
      println();
    }
  }

  class doors(val owner:String){
    val myDoors:ArrayBuffer[door] = ArrayBuffer[door]();

    def addDoor(maerial:String):Unit = {
      myDoors+= new door(maerial)
    }

    def showDoors():Unit = {
      println(owner+" has :")
      for (myDoor <- myDoors){
        myDoor.showInf();
      }
    }
  }

  def main(args: Array[String]): Unit = {
    // val mechnikova = new manyLevelBuilding("mechnikova 77",5);
    // mechnikova.plantFlower("rose")
    // mechnikova.showInf()

    // val saratov = new fridge("iron")
    // val kuhnya = new kitchen(20, 2)
    // val goodDoor = new door("Wood")
    // kuhnya.addFurnit(saratov)
    // kuhnya.addFurnit(goodDoor)
    // kuhnya.showInf();
    // goodDoor.moveDoor();
    // kuhnya.showInf();

    val swetaDoor = new doors("Sweta")
    swetaDoor.addDoor("iron")
    swetaDoor.addDoor("iron")
    swetaDoor.addDoor("wood")
    swetaDoor.addDoor("toy")
    swetaDoor.showDoors();

  }
}
