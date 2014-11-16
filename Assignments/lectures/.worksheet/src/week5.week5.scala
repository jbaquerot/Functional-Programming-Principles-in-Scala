package week5

object week5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  val fruit = List("apples", "oranges", "pears");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(25); 
  val nums = List(1,2,3);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(56); 
  val diag3 = List(List(1,0,0),List(0,1,0),List(0,0,1));System.out.println("""diag3  : List[List[Int]] = """ + $show(diag3 ));$skip(21); 
  val empty = List();System.out.println("""empty  : List[Nothing] = """ + $show(empty ));$skip(191); 
  
  

	def flatten(xs: List[Any]): List[Any] = xs match {
      case List() => xs
      case (z :: zs) :: ys => flatten(z :: zs) ::: flatten(ys)
      case y :: ys => y :: flatten(ys)
    };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(29); val res$0 = 
 		
 		

 	
 	flatten(diag3);System.out.println("""res0: List[Any] = """ + $show(res$0))}
}
