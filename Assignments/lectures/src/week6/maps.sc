package week6

object maps {
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)

  capitalOfCountry("US")                          //> res0: String = Washington
  capitalOfCountry get "Andorra"                  //> res1: Option[String] = None
	capitalOfCountry get "US"                 //> res2: Option[String] = Some(Washington)
}