package week6

object test {
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x*2)                               //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  val pair = List(1,2,3) zip s                    //> pair  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pair unzip                                      //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (c => List('.', c))                   //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res6: Int = 50
  xs.product                                      //> res7: Int = 264
  xs.min                                          //> res8: Int = 1
  xs.max                                          //> res9: Int = 44
  
  def isPrime(n:Int):Boolean =
  	(2 until n) forall(d => n % d != 0)       //> isPrime: (n: Int)Boolean
  	
 isPrime(7)                                       //> res10: Boolean = true
 isPrime(9)                                       //> res11: Boolean = false
 isPrime(73)                                      //> res12: Boolean = true
}