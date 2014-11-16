package week5

object squareList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(151); 

	def squareList1(xs: List[Int]):List[Int] = xs match {
		case Nil => xs
		case x::xs1 => x*x :: squareList1(xs1)
	};System.out.println("""squareList1: (xs: List[Int])List[Int]""");$skip(66); 

	def squareList2(xs: List[Int]): List[Int] =
		xs map (x => x*x);System.out.println("""squareList2: (xs: List[Int])List[Int]""");$skip(29); val res$0 = 


squareList1(List(1,2,6,8));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(27); val res$1 = 
squareList2(List(1,2,6,8));System.out.println("""res1: List[Int] = """ + $show(res$1))}
}
