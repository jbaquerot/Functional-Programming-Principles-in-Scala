package week3

object lecture3 {
  val t1 = new NonEmpty(3,  Empty,  Empty)        //> t1  : week3.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : week3.IntSet = {.3{.4.}}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other:IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  
  def union(other: IntSet): IntSet ={
		((left union right) union other) incl elem
  }
  
  override def toString = "{" + left + elem + right + "}"

}

object Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x,  Empty,  Empty)
  def contains(x: Int): Boolean = false
  def union(other: IntSet) = other
  
  override def toString = "."
}