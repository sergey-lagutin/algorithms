package sc.collection.stacks

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class StackArraySpec extends FlatSpec with Matchers {

  trait EmptyStack {
    val stack = new StackArray[String](10)
  }

  "A Stack without elements" should "be empty" in {
    new EmptyStack {
      assert(stack.isEmpty === true)
    }
  }

  it should "throw runtimeException if pop" in {
    new EmptyStack {
      a[RuntimeException] should be thrownBy {
        stack.pop()
      }
    }
  }

  "A Stack with elements" should "not be empty" in {
    new EmptyStack {
      stack.push("1")
      assert(stack.isEmpty === false)
    }
  }

  it should "pop pushed element" in {
    new EmptyStack {
      val expected = "1"
      stack.push(expected)
      val actual = stack.pop()
      assert(expected === actual)
    }
  }
}