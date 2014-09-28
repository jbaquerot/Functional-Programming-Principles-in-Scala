package example

object workSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); val res$0 = 
  Lists.max(List(1,12,4,5));System.out.println("""res0: Int = """ + $show(res$0));$skip(27); val res$1 = 
  Lists.sum(List(2,5,6,3));System.out.println("""res1: Int = """ + $show(res$1));$skip(20); val res$2 = 
  Lists.max(List());System.out.println("""res2: Int = """ + $show(res$2))}
  
}
