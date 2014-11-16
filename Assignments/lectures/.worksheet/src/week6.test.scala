package week6

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  val xs = Array(1, 2, 3, 44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(20); val res$0 = 
  xs map (x => x*2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(27); 
  
  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (c => c.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(28); val res$2 = 
  s exists (c => c.isUpper);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(28); val res$3 = 
  s forall (c => c.isUpper);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(34); 
  
  val pair = List(1,2,3) zip s;System.out.println("""pair  : List[(Int, Char)] = """ + $show(pair ));$skip(13); val res$4 = 
  pair unzip;System.out.println("""res4: (List[Int], List[Char]) = """ + $show(res$4));$skip(35); val res$5 = 
  
  s flatMap (c => List('.', c));System.out.println("""res5: String = """ + $show(res$5));$skip(12); val res$6 = 
  
  xs.sum;System.out.println("""res6: Int = """ + $show(res$6));$skip(13); val res$7 = 
  xs.product;System.out.println("""res7: Int = """ + $show(res$7));$skip(9); val res$8 = 
  xs.min;System.out.println("""res8: Int = """ + $show(res$8));$skip(9); val res$9 = 
  xs.max;System.out.println("""res9: Int = """ + $show(res$9));$skip(73); 
  
  def isPrime(n:Int):Boolean =
  	(2 until n) forall(d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(16); val res$10 = 
  	
 isPrime(7);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(12); val res$11 = 
 isPrime(9);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(13); val res$12 = 
 isPrime(73);System.out.println("""res12: Boolean = """ + $show(res$12))}
}
