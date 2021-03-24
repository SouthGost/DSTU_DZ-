object In4 {
    trait power[T] {
      def vozvedenie: T
      val stepen = 4
      val rezult: T
    }

    class powI(val osnovanie: Int) extends power[Int] {
      override def vozvedenie: Int = {
        var rez = 1
        for (i <- 1 to stepen) {
          rez = rez * osnovanie
        }
        rez
      }

      override val rezult = vozvedenie
    }

    class powD(val osnovanie: Int) extends power[Double] {
      override def vozvedenie: Double = {
        var rez = 1
        for (i <- 1 to stepen) {
          rez = rez * osnovanie
        }
        rez
      }

      override val rezult = vozvedenie
    }
}
