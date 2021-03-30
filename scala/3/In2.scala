object In2 {
  trait power extends osnovanie.osnovanie {

    def vozvedenie2: Double = {
      var rez:Double = 1.0
      for (i <- 1 to 2) {
        rez = rez * osnovanie
      }
      rez
    }
  }
}
