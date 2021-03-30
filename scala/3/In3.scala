object In3 {
  trait power extends osnovanie.osnovanie {

    def vozvedenie3: Double = {
      var rez:Double = 1.0
      for (i <- 1 to 3) {
        rez = rez * osnovanie
      }
      rez
    }
  }
}
