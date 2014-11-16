package week5
import math.Ordering

object mergeSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(482); 
  def msort[T](xs: List[T])(implicit ord:Ordering[T]):List[T] ={
  	val n = xs.length/2
  	if (n == 0) xs
  	else {
  		def merge(xs:List[T], ys:List[T]): List[T] = (xs, ys) match {
  			case(Nil, ys) => ys
  			case(xs, Nil) => xs
  			case(x::xs1, y::ys1) =>
  				if (ord.lt(x,y)) x :: merge(xs1, ys)
  				else y :: merge(xs, ys1)
  		}
  		
  		val (fst, snd) = xs splitAt n
  		merge(msort(fst), msort(snd))
  		
  	}
  };System.out.println("""msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]""");$skip(34); 
  
  val nums = List(-2,4,1,-5,2);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(61); 
  val fruits = List("apple", "pinapple", "orange","bannana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(17); val res$0 = 
  
  msort(nums);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
  msort(fruits);System.out.println("""res1: List[String] = """ + $show(res$1))}
}
