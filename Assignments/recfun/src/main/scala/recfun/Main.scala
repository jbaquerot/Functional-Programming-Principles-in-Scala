package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    // the edge of triangle and the borders
    if (c == 0 | c == r) 1
    else {
      pascal(c-1, r-1) + pascal(c, r-1)
    }
    
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def balAccum(numLeftPar: Int, chars: List[Char]): Boolean = {
      if (numLeftPar < 0)
        false
      else
    	  if (chars.isEmpty)  
    		  numLeftPar == 0
      else {
        val firstChar = chars.head
        if (firstChar == '(')
          balAccum(numLeftPar + 1, chars.tail)
        else if (firstChar == ')')
        		balAccum(numLeftPar - 1, chars.tail)
        	else
        		balAccum(numLeftPar, chars.tail)
      }
    }
      
    balAccum(0, chars)
  }
    


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0 || coins.isEmpty){
    	if (!coins.isEmpty) 1 else 0
    }
    else {
      val coin = coins.head
      val coinsTail = coins.tail
      if (money == coin && coinsTail.isEmpty) {
        1
      }
      else if (money < coin) {
    	  		countChange(money, coinsTail)
      		}
      		else {
      		  countChange(money-coin, coins) + countChange(money, coinsTail)  
      		}
      
    }
  }
    

}
