import common._

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(97); 
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : <error> = """ + $show(t1 ));$skip(103); 
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9);System.out.println("""t2  : <error> = """ + $show(t2 ))}

}
