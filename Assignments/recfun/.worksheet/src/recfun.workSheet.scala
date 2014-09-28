package recfun

import Main.countChange

object workSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); val res$0 = 
	countChange(4,List(1,5));System.out.println("""res0: Int = """ + $show(res$0));$skip(27); val res$1 = 
  countChange(0,List(1,3));System.out.println("""res1: Int = """ + $show(res$1))}
}
