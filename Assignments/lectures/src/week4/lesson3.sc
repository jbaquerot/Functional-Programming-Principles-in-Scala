package week4
import week4._
object lesson3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    		 else nth(n - 1, xs.tail)

  }                                               //> nth: [T](n: Int, xs: week4.List[T])T

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week4.Cons[Int] = week4.Cons@35ed35e0

  nth(0, list)                                    //> res0: Int = 1
  nth(2, list)                                    //> res1: Int = 3
  nth(-1, list)                                   //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week4.lesson3$$anonfun$main$1.nth$1(week4.lesson3.scala:6)
                                                  //| 	at week4.lesson3$$anonfun$main$1.apply$mcV$sp(week4.lesson3.scala:16)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week4.lesson3$.main(week4.lesson3.scala:3)
                                                  //| 	at week4.lesson3.main(week4.lesson3.scala)
}