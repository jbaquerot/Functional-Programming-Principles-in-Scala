package forcomp
import Anagrams._


object test2 {
	val sentence = List("linux", "rulez")
	
	/*def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
		def occurrencesAnagrams(occurrences: Occurrences) = occurrences match {
			case List() => List()
			case x::xs =>
		}
		
		occurrencesAnagrams(sentenceOccurrences(sentence))
	
	}*/
	//wordOccurrences((sentence foldRight "") (_ ++ _))
	
	val occurrences = sentenceOccurrences(sentence)
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
	
	}
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