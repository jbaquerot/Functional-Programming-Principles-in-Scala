package patmat

import org.scalatest.FunSuite
import common._
import patmat.Huffman._

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(167); 
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : patmat.Huffman.Fork = """ + $show(t1 ));$skip(103); 
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9);System.out.println("""t2  : patmat.Huffman.Fork = """ + $show(t2 ));$skip(26); 
		val trees = List(t1,t2);System.out.println("""trees  : List[patmat.Huffman.Fork] = """ + $show(trees ));$skip(32); 
    
    println(decodedSecret);$skip(33); 
    
    val table = convert(t2);System.out.println("""table  : patmat.Huffman.CodeTable = """ + $show(table ));$skip(25); val res$0 = 
    codeBits(table)('d');System.out.println("""res0: List[patmat.Huffman.Bit] = """ + $show(res$0));$skip(52); val res$1 = 
    
    
    quickEncode(t2)(string2Chars("abda"));System.out.println("""res1: List[patmat.Huffman.Bit] = """ + $show(res$1));$skip(285); 
    val bits =  List(1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1);System.out.println("""bits  : List[Int] = """ + $show(bits ));$skip(285); 
    val bits2 = List(0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1);System.out.println("""bits2  : List[Int] = """ + $show(bits2 ));$skip(52); 
    
    val frenchWorld = decode(frenchCode, bits);System.out.println("""frenchWorld  : List[Char] = """ + $show(frenchWorld ));$skip(49); 
    val frenchWorld2 = decode(frenchCode, bits2);System.out.println("""frenchWorld2  : List[Char] = """ + $show(frenchWorld2 ));$skip(44); val res$2 = 
    bits == encode(frenchCode)(frenchWorld);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(51); val res$3 = 
    bits2 == quickEncode(frenchCode)(frenchWorld2);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(76); val res$4 = 
    quickEncode(frenchCode)(frenchWorld) == encode(frenchCode)(frenchWorld);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(49); val res$5 = 
    
 		createCodeTree(string2Chars("someText"));System.out.println("""res5: patmat.Huffman.CodeTree = """ + $show(res$5));$skip(457); 
                                                  
                                                  

 		
 	def encodeChar(tree:CodeTree, c:Char, accum:List[Bit]): List[Bit] = tree match{
 	  	case Leaf(c1,w) =>
 	  	  if (c == c1) {
 	  	    //println(accum)
 	  	    accum.reverse
 	  	  }
 	  	  else List()
 	    case Fork(ltree, rtree, arrchars, w) => {
 	  	  		encodeChar(ltree, c, 0::accum) ::: encodeChar(rtree, c, 1::accum)
 	  	  		
 	    }
 	};System.out.println("""encodeChar: (tree: patmat.Huffman.CodeTree, c: Char, accum: List[patmat.Huffman.Bit])List[patmat.Huffman.Bit]""");$skip(38); val res$6 = 
  encodeChar(frenchCode, 'b', List());System.out.println("""res6: List[patmat.Huffman.Bit] = """ + $show(res$6));$skip(37); val res$7 = 
  quickEncode(frenchCode)(List('b'));System.out.println("""res7: List[patmat.Huffman.Bit] = """ + $show(res$7))}

}
