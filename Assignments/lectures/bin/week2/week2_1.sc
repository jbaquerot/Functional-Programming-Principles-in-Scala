package week2

object week2_1 {
 	
	val x = new Rational(1,3)                 //> x  : week2.Rational = 1/3
	val y = new Rational(5,7)                 //> y  : week2.Rational = 5/7
	val z = new Rational(3,2)                 //> z  : week2.Rational = 3/2
	
	x + y *z                                  //> res0: week2.Rational = 59/42
	
	x - y -z                                  //> res1: week2.Rational = -79/42
	y + y                                     //> res2: week2.Rational = 10/7
	x < y                                     //> res3: Boolean = true
	x max y                                   //> res4: week2.Rational = 5/7
	new Rational(2)                           //> res5: week2.Rational = 2/1
}


class Rational(x: Int, y: Int){
		require(y != 0, "denominator must be nonzero")
		
		def this(x: Int) = this(x, 1)
		
		private def gcd(a: Int, b:Int): Int = if (b == 0) a else gcd(b, a % b)
  	def numer = x
  	def denom = y
  	
  	def < (that: Rational) = numer * that.denom < that.numer * denom
  	def max(that: Rational) = if (this < that) that else this
  	
  	def + (r: Rational) =
  		new Rational(numer * r.denom + r.numer * denom, denom * r.denom)
  	def * (r: Rational) =
  		new Rational(numer * r.numer , denom * r.denom)
  	def unary_- : Rational =
  		new Rational( -numer, denom)
  	def - (r: Rational) =
        this + - r
  		
  	override def toString = {
  		var g = gcd(numer, denom)
  	  numer/g + "/" + denom/g
  	}
}