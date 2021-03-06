package week2

object Week2 {
 def sum(f: Int => Int): (Int, Int) => Int = {
 		def sumF(a: Int, b: Int): Int =
 			if (a > b) 0
 			else f(a) + sumF(a+1, b)
 		sumF
 }                                                //> sum: (f: Int => Int)(Int, Int) => Int
 
 sum( x => x*x)( 1, 10)                           //> res0: Int = 385
 
 def sum2(f: Int => Int)(a:Int, b: Int): Int =
 		if (a > b) 0 else f(a) + sum2(f)(a + 1, b)
                                                  //> sum2: (f: Int => Int)(a: Int, b: Int)Int
 
 sum2( x => x*x)( 1, 10)                          //> res1: Int = 385
 
 
 
 
 def prod(f: Int => Int, a: Int, b: Int): Int =
 		if (a > b) 1
 		else f(a) * prod(f, a+1, b)       //> prod: (f: Int => Int, a: Int, b: Int)Int
 		
 def fact(n: Int) = prod(x => x, 1, n)            //> fact: (n: Int)Int
 
 fact(5)                                          //> res2: Int = 120

def sumIter(f: Int => Int)(a: Int, b: Int): Int = {
	def loop(a: Int, acc:Int): Int ={
		if (a > b) acc
		else loop(a+1, f(a)+acc)
	}
	loop(a, 0)
}                                                 //> sumIter: (f: Int => Int)(a: Int, b: Int)Int

sumIter(x => x*x)( 1, 10)                         //> res3: Int = 385


}