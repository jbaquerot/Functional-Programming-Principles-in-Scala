package forcomp
import Anagrams._


object test2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
	val sentence = List("linux", "rulez");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(353); 
	
	/*def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
		def occurrencesAnagrams(occurrences: Occurrences) = occurrences match {
			case List() => List()
			case x::xs =>
		}
		
		occurrencesAnagrams(sentenceOccurrences(sentence))
	
	}*/
	//wordOccurrences((sentence foldRight "") (_ ++ _))
	
	val occurrences = sentenceOccurrences(sentence);System.out.println("""occurrences  : forcomp.Anagrams.Occurrences = """ + $show(occurrences ));$skip(305); 
	//val
	
	def subSets(occurrences: Occurrences, accum: List[Occurrences]):List[Occurrences] = occurrences match{
		case List() => accum
		case x::xs => {
			for{
				occ <- occurrences
				occAcumm = occ::accum
				sub <- subSets(subtract(occurrences, occAcumm ), occAcumm)
			} yield occ :: sub
		}
	
	};System.out.println("""subSets: (occurrences: forcomp.Anagrams.Occurrences, accum: List[forcomp.Anagrams.Occurrences])List[forcomp.Anagrams.Occurrences]""")}
	/*for {
		comb <- combinationsOfN(occurrences, occurrences.length)
		occ <- comb
		n <- 1 to occ._2
		//words <- dictionaryByOccurrences(comb)
	} yield words     */
	
	
// dictionaryByOccurrences(combinations(sentenceOccurrences(sentence)))
	
	//wordAnagrams("rulez")
	
	
	//sentenceAnagrams(sentence).toSet
}
