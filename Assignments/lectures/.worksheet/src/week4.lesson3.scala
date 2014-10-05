package week4
import week4._
object lesson3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  println("Welcome to the Scala worksheet");$skip(163); 
  def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    		 else nth(n - 1, xs.tail)

  };System.out.println("""nth: [T](n: Int, xs: week4.List[T])T""");$skip(61); 

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week4.Cons[Int] = """ + $show(list ));$skip(16); val res$0 = 

  nth(0, list);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  nth(2, list);System.out.println("""res1: Int = """ + $show(res$1));$skip(16); val res$2 = 
  nth(-1, list);System.out.println("""res2: Int = """ + $show(res$2))}
}
