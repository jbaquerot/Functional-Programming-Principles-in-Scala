package example

object workSheet {
  Lists.max(List(1,12,4,5))                       //> res0: Int = 12
  Lists.sum(List(2,5,6,3))                        //> res1: Int = 16
  Lists.max(List())                               //> java.lang.IllegalArgumentException: Empty List is not allowed
                                                  //| 	at example.Lists$.max(Lists.scala:45)
                                                  //| 	at example.workSheet$$anonfun$main$1.apply$mcV$sp(example.workSheet.scal
                                                  //| a:6)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at example.workSheet$.main(example.workSheet.scala:3)
                                                  //| 	at example.workSheet.main(example.workSheet.scala)
  
}