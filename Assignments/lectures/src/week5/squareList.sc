package week5

object squareList {

	def squareList1(xs: List[Int]):List[Int] = xs match {
		case Nil => xs
		case x::xs1 => x*x :: squareList1(xs1)
	}                                         //> squareList1: (xs: List[Int])List[Int]

	def squareList2(xs: List[Int]): List[Int] =
		xs map (x => x*x)                 //> squareList2: (xs: List[Int])List[Int]


squareList1(List(1,2,6,8))                        //> res0: List[Int] = List(1, 4, 36, 64)
squareList2(List(1,2,6,8))                        //> res1: List[Int] = List(1, 4, 36, 64)
}