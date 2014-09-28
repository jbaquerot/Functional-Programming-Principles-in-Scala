package week2

object week2_1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
 	
	val x = new Rational(1,3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(27); 
	val y = new Rational(5,7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(27); 
	val z = new Rational(3,2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(12); val res$0 = 
	
	x + y *z;System.out.println("""res0: week2.Rational = """ + $show(res$0));$skip(12); val res$1 = 
	
	x - y -z;System.out.println("""res1: week2.Rational = """ + $show(res$1));$skip(7); val res$2 = 
	y + y;System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(7); val res$3 = 
	x < y;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(9); val res$4 = 
	x max y;System.out.println("""res4: week2.Rational = """ + $show(res$4));$skip(17); val res$5 = 
	new Rational(2);System.out.println("""res5: week2.Rational = """ + $show(res$5))}
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
