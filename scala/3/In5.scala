object In5 {
  trait power extends osnovanie.osnovanie {

    def vozvedenie5: Double = {
      var rez:Double = 1.0
      for (i <- 1 to 5) {
        rez = rez * osnovanie
      }
      rez
    }
  }
}