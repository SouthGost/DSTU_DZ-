object In4 {
  trait power extends osnovanie.osnovanie {

    def vozvedenie4: Double = {
      var rez:Double = 1.0
      for (i <- 1 to 4) {
        rez = rez * osnovanie
      }
      rez
    }
  }
}
