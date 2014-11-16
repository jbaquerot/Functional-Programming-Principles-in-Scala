package week5

object week5 {
  val fruit = List("apples", "oranges", "pears")  //> fruit  : List[String] = List(apples, oranges, pears)
  val nums = List(1,2,3)                          //> nums  : List[Int] = List(1, 2, 3)
  val diag3 = List(List(1,0,0),List(0,1,0),List(0,0,1))
                                                  //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //| 
  val empty = List()                              //> empty  : List[Nothing] = List()
  
  

	def flatten(xs: List[Any]): List[Any] = xs match {
      case List() => xs
      case (z :: zs) :: ys => flatten(z :: zs) ::: flatten(ys)
      case y :: ys => y :: flatten(ys)
    }                                             //> flatten: (xs: List[Any])List[Any]
 		
 		

 	
 	flatten(diag3)                            //> res0: List[Any] = List(1, 0, 0, 0, 1, 0, 0, 0, 1)
}