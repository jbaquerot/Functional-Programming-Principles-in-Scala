package patmat

import org.scalatest.FunSuite
import common._
import patmat.Huffman._

object worksheet {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
                                                  //> t2  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf
                                                  //| (d,4),List(a, b, d),9)
		val trees = List(t1,t2)           //> trees  : List[patmat.Huffman.Fork] = List(Fork(Leaf(a,2),Leaf(b,3),List(a, b
                                                  //| ),5), Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf(d,4),List(a, b, d),9)
                                                  //| )
    
    println(decodedSecret)                        //> List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
    
    val table = convert(t2)                       //> table  : patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (d,
                                                  //| List(1)))
    codeBits(table)('d')                          //> res0: List[patmat.Huffman.Bit] = List(1)
    
    
    quickEncode(t2)(string2Chars("abda"))         //> res1: List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 1, 0, 0)
    val bits =  List(1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1)
                                                  //> bits  : List[Int] = List(1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 
                                                  //| 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0
                                                  //| , 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,
                                                  //|  0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1)
    val bits2 = List(0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1)
                                                  //> bits2  : List[Int] = List(0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1
                                                  //| , 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1
                                                  //| , 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0
                                                  //| , 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1)
    
    val frenchWorld = decode(frenchCode, bits)    //> frenchWorld  : List[Char] = List(e, n, c, o, r, e, u, n, t, e, x, t, e, t, 
                                                  //| r, e, s, s, e, c, r, e, t)
    val frenchWorld2 = decode(frenchCode, bits2)  //> frenchWorld2  : List[Char] = List(p, l, d, c, s, e, i, t, p, r, e, l, t, t,
                                                  //|  r, m, s, f, x, u)
    bits == encode(frenchCode)(frenchWorld)       //> res2: Boolean = true
    bits2 == quickEncode(frenchCode)(frenchWorld2)//> res3: Boolean = false
    quickEncode(frenchCode)(frenchWorld) == encode(frenchCode)(frenchWorld)
                                                  //> res4: Boolean = true
    
 		createCodeTree(string2Chars("someText"))
                                                  //> res5: patmat.Huffman.CodeTree = Fork(Fork(Fork(Leaf(T,1),Leaf(m,1),List(T, 
                                                  //| m),2),Fork(Leaf(o,1),Leaf(s,1),List(o, s),2),List(T, m, o, s),4),Fork(Fork(
                                                  //| Leaf(t,1),Leaf(x,1),List(t, x),2),Leaf(e,2),List(t, x, e),4),List(T, m, o, 
                                                  //| s, t, x, e),8)
                                                  
                                                  

 		
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
 	}                                         //> encodeChar: (tree: patmat.Huffman.CodeTree, c: Char, accum: List[patmat.Huf
                                                  //| fman.Bit])List[patmat.Huffman.Bit]
  encodeChar(frenchCode, 'b', List())             //> res6: List[patmat.Huffman.Bit] = List(1, 0, 0, 1, 1, 1, 1)
  quickEncode(frenchCode)(List('b'))              //> res7: List[patmat.Huffman.Bit] = List(1, 0, 0, 1, 1, 1, 1)

}