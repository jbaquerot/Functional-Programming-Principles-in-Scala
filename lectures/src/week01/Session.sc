package week01

object Session {

  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < 0.001 * x

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1)
  }                                               //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(10)                                        //> res2: Double = 3.16245562280389
  sqrt(1e-20)                                     //> res3: Double = 1.0000021484861236E-10

}