package forcomp

import Anagrams._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(822); 
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
 };System.out.println("""combinations: (occurrences: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(37); 
 
 val abba = List(('a', 2),('b',2));System.out.println("""abba  : List[(Char, Int)] = """ + $show(abba ));$skip(13); val res$0 = 
 abba.length;System.out.println("""res0: Int = """ + $show(res$0));$skip(20); val res$1 = 
 combinations(abba);System.out.println("""res1: List[forcomp.Anagrams.Occurrences] = """ + $show(res$1));$skip(16); val res$2 = 
 
 
 dictionary;System.out.println("""res2: List[forcomp.Anagrams.Word] = """ + $show(res$2))}

  
}
