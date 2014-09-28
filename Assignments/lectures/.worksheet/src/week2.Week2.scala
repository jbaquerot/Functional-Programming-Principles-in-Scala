package week2

object Week2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(168); 
 def sum(f: Int => Int): (Int, Int) => Int = {
 		def sumF(a: Int, b: Int): Int =
 			if (a > b) 0
 			else f(a) + sumF(a+1, b)
 		sumF
 };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(26); val res$0 = 
 
 sum( x => x*x)( 1, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(95); 
 
 def sum2(f: Int => Int)(a:Int, b: Int): Int =
 		if (a > b) 0 else f(a) + sum2(f)(a + 1, b);System.out.println("""sum2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$1 = 
 
 sum2( x => x*x)( 1, 10);System.out.println("""res1: Int = """ + $show(res$1));$skip(103); 
 
 
 
 
 def prod(f: Int => Int, a: Int, b: Int): Int =
 		if (a > b) 1
 		else f(a) * prod(f, a+1, b);System.out.println("""prod: (f: Int => Int, a: Int, b: Int)Int""");$skip(43); 
 		
 def fact(n: Int) = prod(x => x, 1, n);System.out.println("""fact: (n: Int)Int""");$skip(11); val res$2 = 
 
 fact(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(149); 

def sumIter(f: Int => Int)(a: Int, b: Int): Int = {
	def loop(a: Int, acc:Int): Int ={
		if (a > b) acc
		else loop(a+1, f(a)+acc)
	}
	loop(a, 0)
};System.out.println("""sumIter: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$3 = 

sumIter(x => x*x)( 1, 10);System.out.println("""res3: Int = """ + $show(res$3))}


}
