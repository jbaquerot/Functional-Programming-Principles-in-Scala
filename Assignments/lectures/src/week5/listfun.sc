package week5

object listfun {
  val nums = List(9,-2,4,1,-5,2)                  //> nums  : List[Int] = List(9, -2, 4, 1, -5, 2)
  val fruits = List("apple", "pinapple", "orange","bannana")
                                                  //> fruits  : List[String] = List(apple, pinapple, orange, bannana)
  
  nums filter (x => x>0)                          //> res0: List[Int] = List(9, 4, 1, 2)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-2, -5)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(9, 4, 1, 2),List(-2, -5))
  
  nums takeWhile (x => x > 0)                     //> res3: List[Int] = List(9)
  nums dropWhile (x => x > 0)                     //> res4: List[Int] = List(-2, 4, 1, -5, 2)
  val s = nums span (x => x > 0)                  //> s  : (List[Int], List[Int]) = (List(9),List(-2, 4, 1, -5, 2))
  s._1                                            //> res5: List[Int] = List(9)
  s._2                                            //> res6: List[Int] = List(-2, 4, 1, -5, 2)
  
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 => {
    	val (first, rest) = xs span (y => y == x)
    	first :: pack(rest)
    }
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  
  pack(List("a", "a", "a", "b", "c", "c", "a")) map (xs => (xs.head, xs.length))
                                                  //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  
  
  def encode[T](xs:List[T]):List[(T,Int)] = {
  	pack(xs) map (ys => (ys.head, ys.length))
  
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  
  encode(List("a", "a", "a", "b", "c", "c", "a")) //> res8: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  
  def concat[T](xs: List[T], ys: List[T]): List[T] =
  	(xs foldRight ys)(_ :: _)                 //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  val l=List("a", "a", "a", "b", "c", "c", "a")   //> l  : List[String] = List(a, a, a, b, c, c, a)
  concat(l,l)                                     //> res9: List[String] = List(a, a, a, b, c, c, a, a, a, a, b, c, c, a)
  
  /*def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(  map f )
    
  mapFun(nums, 	n => n)
 */
}