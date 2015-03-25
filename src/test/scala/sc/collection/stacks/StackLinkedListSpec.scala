package sc.collection.stacks

import org.scalatest.{FlatSpec, Matchers}

class StackLinkedListSpec extends FlatSpec with Matchers {

  trait EmptyStack {
    val stack = new StackLinkedList[String]()
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