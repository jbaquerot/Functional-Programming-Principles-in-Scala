package week5

object listfun {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  val nums = List(9,-2,4,1,-5,2);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(61); 
  val fruits = List("apple", "pinapple", "orange","bannana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(28); val res$0 = 
  
  nums filter (x => x>0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  nums filterNot (x => x > 0);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(30); val res$2 = 
  nums partition (x => x > 0);System.out.println("""res2: (List[Int], List[Int]) = """ + $show(res$2));$skip(33); val res$3 = 
  
  nums takeWhile (x => x > 0);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
  nums dropWhile (x => x > 0);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(33); 
  val s = nums span (x => x > 0);System.out.println("""s  : (List[Int], List[Int]) = """ + $show(s ));$skip(7); val res$5 = 
  s._1;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(7); val res$6 = 
  s._2;System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(191); 
  
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 => {
    	val (first, rest) = xs span (y => y == x)
    	first :: pack(rest)
    }
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(87); val res$7 = 
  
  
  pack(List("a", "a", "a", "b", "c", "c", "a")) map (xs => (xs.head, xs.length));System.out.println("""res7: List[(String, Int)] = """ + $show(res$7));$skip(104); 
  
  
  def encode[T](xs:List[T]):List[(T,Int)] = {
  	pack(xs) map (ys => (ys.head, ys.length))
  
  };System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(53); val res$8 = 
  
  encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res8: List[(String, Int)] = """ + $show(res$8));$skip(85); 
  
  def concat[T](xs: List[T], ys: List[T]): List[T] =
  	(xs foldRight ys)(_ :: _);System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(51); 
  
  val l=List("a", "a", "a", "b", "c", "c", "a");System.out.println("""l  : List[String] = """ + $show(l ));$skip(14); val res$9 = 
  concat(l,l);System.out.println("""res9: List[String] = """ + $show(res$9))}
  
  /*def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(  map f )
    
  mapFun(nums, 	n => n)
 */
}
