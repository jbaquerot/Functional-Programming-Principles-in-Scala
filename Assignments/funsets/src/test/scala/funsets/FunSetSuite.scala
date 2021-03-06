package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s1000 = singletonSet(1000)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
    test("intersect contains no elements") {
    new TestSets {
      println("interset containts no elements")
      val s = intersect(s1, s2)
      printSet(s)
      assert(!contains(s, 1), "Union 1")
      assert(!contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
    
    test("intersect contains elements") {
    new TestSets {
      val s1s2 = union(s1, s2)
      val s = intersect(s1s2, s1)
      assert(contains(s, 1), "Union 1")
      assert(!contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
    
  test("diff contains elements") {
    new TestSets {
      val s1s2 = union(s1, s2)
      val s = diff(s1s2, s1)
      assert(!contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("filter contains elements") {
    new TestSets {
      val s1s2 = union(s1, s2)
      val f = filter(s1s2, (x => x < 2) )
      assert(!contains(f, 2) , "filter s1s2(x < 2) should not containt 2")
      assert(contains(f, 1) , "filter s1s2(x < 2) should containt 1")
    }
  }
  
  test("Forall contains elements") {
    new TestSets {
      val s1s2 = union(s1, s2)
      val s1s2s3 = union(s1s2, s3)
      assert(!forall(s1s2s3, (x => x < 1) ) , "forall s1s2s3(x < 1) should be false")
      assert(forall(s1s2s3, (x => x < 20) ) , "forall s1s2s3(x < 20) should be true")
    }
  }
  
  test("forall: {1,3,4,5,7,1000} x => (x<5)" ) {
    new TestSets {
       val u = union(singletonSet(1), singletonSet(3));
       val u1 = union(u, singletonSet(4))
       val u2 = union(u1, singletonSet(5))
       val u3 = union(u2, singletonSet(7))
       val u4 = union(u3, singletonSet(1000))
       println("forall : {1,3,4,5,7,1000}, x => (x < 5)")      
       //val u5 = 
       println(forall(u4, x => (x < 5)))
       assert(forall(u4, x => (x < 5)) === false, "should be false")
/*       assert(contains(u5,3), "should contain 3")
       assert(contains(u5,4), "should contain 4")
       assert(!contains(u5,5), "should not contain 5")
       assert(!contains(u5,7), "should not contain 7")
       assert(!contains(u5,1000), "should not contain 1000")*/
    }
  }
  
  test("Forall contains elements2") {
    new TestSets {
      val s1s2 = union(s1, s2)
      val s1s2s3 = union(s1s2, s3)
      val s1s2s3s1000 = union(s1s2s3, s1000)
      assert(!forall(s1s2s3s1000, (x => x < 1) ) , "forall s1s2s3s1000(x < 1) should be false")
      assert(forall(s1s2s3, (x => x < 5) ) , "forall s1s2s3s1000(x < 5) should be true")
    }
  }
  
 test("exists") {
    new TestSets {
      val s1s2 = union(s1, s2)
      println("exists test")
      printSet(s1s2)
      assert(!exists(s1s2, (x => x > 3) ) , "exists(s1s2, x>3) should be false")
      assert(exists(s1s2, (x => x < 2) ) , "exists(s1s2, x<2) should be  true")
    }
  }
 
  test("exists: {1,2,3,4} x => (x == 2)" ) {
    new TestSets {
       val u = union(singletonSet(1), singletonSet(2));
       val u1 = union(u, singletonSet(3))
       val u2 = union(u1, singletonSet(4))
       println("exists : {1,2,3,4}, x => (x == 2)")      
       //val u5 = 
       println(exists(u2, x => (x == 2)))
       assert(exists(u2, x => (x == 2)) === true, "exists : {1,2,3,4}, x => (x == 2) should be true")
       println("exists : {1,2,3,4}, x => (x == 5)")      
       //val u5 = 
       println(exists(u2, x => (x == 5)))
       assert(exists(u2, x => (x == 5)) === false, "exists : {1,2,3,4}, x => (x == 5) should be false")

    }
  }
 
 
 test("map test") {
    new TestSets {
      val s1s3s1000 = union(union(s1, s3), s1000)
      println("map test: union(s1, s3, s1000)")
      printSet(s1s3s1000)
      val f = map(s1s3s1000, x => x * 2 )
      println("map test")
      printSet(f)
      assert(!contains(f, 1) , "map s1s2(x * 2) should not containt 1")
      assert(contains(f, 2) , "map s1s2(x * 2) should  containt 2")
      assert(contains(f, 6) , "map s1s2(x * 2) should  containt 6")
      assert(contains(f, 2000) , "map s1s2s1000(x * 2) should  containt 2000")
      
    }
  }
 
  test("map test2") {
    new TestSets {
      val s1s3s500 = union(union(s1, s3), singletonSet(500))
      println("map test: union(s1, s3, s500)")
      printSet(s1s3s500)
      val f = map(s1s3s500, x => x * 2 )
      println("map test")
      printSet(f)
      assert(!contains(f, 1) , "map s1s2(x * 2) should not containt 1")
      assert(contains(f, 2) , "map s1s2(x * 2) should  containt 2")
      assert(contains(f, 6) , "map s1s2(x * 2) should  containt 6")
      assert(contains(f, 1000) , "map s1s2s500(x * 2) should  containt 1000")
      
    }
  }
   test("map : {1,3,4,5,7,1000}, x => (x-1)") {
     new TestSets {
       val u = union(singletonSet(1), singletonSet(3));
       val u1 = union(u, singletonSet(4))
       val u2 = union(u1, singletonSet(5))
       val u3 = union(u2, singletonSet(7))
       val u4 = union(u3, singletonSet(1000))
       println("map : {1,3,4,5,7,1000}, x => (x-1)")
       
       val u5 = map(u4, x => (x-1))
       printSet(u5)
       assert(contains(u5,0), "should contain 0")
       assert(contains(u5,2), "should contain 2")
       assert(contains(u5,3), "should contain 3")
       assert(contains(u5,4), "should contain 4")
       assert(contains(u5,6), "should contain 6")
       assert(contains(u5,999), "should contain 999")
     }
   }
  
}
