package forcomp

import Anagrams._

object test {
 def combinations(occurrences: Occurrences): List[Occurrences] = {
 	def combinationsOfN(occs: Occurrences, n:Int): List[Occurrences] = {
 		if (n == 0) List(List())
 		else if (n == 1)
 					for {
 								oc <- occs
 								i <- 1 to oc._2
 					} yield List((oc._1, i))
 				else for {
 			o <- occs
 			comb <- combinationsOfN(occs, n-1)
 			if comb.forall(x => (o._1 < x._1) | ((o._1 == x._1) & (o._2 < x._2)))
 			i <- 1 to o._2
 		} yield (o._1,i)::comb
 		} //end combinationsOfN
 	def combinationsAll(occurrences: Occurrences, m: Int): List[Occurrences] = {
 		if (m == 0)
 			combinationsOfN(occurrences, 0)
 		else combinationsOfN(occurrences, m):::combinationsAll(occurrences,m-1)
 	} //end combinationsAll
 	combinationsAll(occurrences,occurrences.length)
 }                                                //> combinations: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagra
                                                  //| ms.Occurrences]
 
 val abba = List(('a', 2),('b',2))                //> abba  : List[(Char, Int)] = List((a,2), (b,2))
 abba.length                                      //> res0: Int = 2
 combinations(abba)                               //> res1: List[forcomp.Anagrams.Occurrences] = List(List((a,1), (b,1)), List((a,
                                                  //| 2), (b,1)), List((a,1), (b,2)), List((a,2), (b,2)), List((a,1)), List((a,2))
                                                  //| , List((b,1)), List((b,2)), List())
 
 
 dictionary                                       //> res2: List[forcomp.Anagrams.Word] = List(Aarhus, Aaron, Ababa, aback, abaft,
                                                  //|  abandon, abandoned, abandoning, abandonment, abandons, abase, abased, abase
                                                  //| ment, abasements, abases, abash, abashed, abashes, abashing, abasing, abate,
                                                  //|  abated, abatement, abatements, abater, abates, abating, Abba, abbe, abbey, 
                                                  //| abbeys, abbot, abbots, Abbott, abbreviate, abbreviated, abbreviates, abbrevi
                                                  //| ating, abbreviation, abbreviations, Abby, abdomen, abdomens, abdominal, abdu
                                                  //| ct, abducted, abduction, abductions, abductor, abductors, abducts, Abe, abed
                                                  //| , Abel, Abelian, Abelson, Aberdeen, Abernathy, aberrant, aberration, aberrat
                                                  //| ions, abet, abets, abetted, abetter, abetting, abeyance, abhor, abhorred, ab
                                                  //| horrent, abhorrer, abhorring, abhors, abide, abided, abides, abiding, Abidja
                                                  //| n, Abigail, Abilene, abilities, ability, abject, abjection, abjections, abje
                                                  //| ctly, abjectness, abjure, abjured, abjures, abjuring, ablate, ablated, ablat
                                                  //| es, ablating, ablation, 
                                                  //| Output exceeds cutoff limit.

  
}