package sc.collection.queues

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class QueueLinkedListSpec extends FlatSpec with Matchers {

  trait EmptyQueue {
    val queue = new QueueLinkedList[String]
  }

  "Empty queue" should "be empty" in {
    new EmptyQueue {
      assert(queue.isEmpty === true)
    }
  }

  it should "throw exception when dequeue" in {
    new EmptyQueue {
      a[RuntimeException] should be thrownBy {
        queue.dequeue()
      }
    }
  }

  "Queue" should "be non empty if element is enqueued" in {
    new EmptyQueue {
      queue.enqueue("1")
      assert(queue.isEmpty === false)
    }
  }

  it should "dequeue enqueued element" in {
    new EmptyQueue {
      val expected = "1"
      queue.enqueue(expected)
      val actual = queue.dequeue()
      assert(expected === actual)
    }
  }

  it should "enqueue and dequeue few times" in {
    new EmptyQueue {
      val expected1 = "1"
      val expected2 = "2"
      queue.enqueue(expected1)
      queue.enqueue(expected2)

      assert(expected1 === queue.dequeue())
      assert(expected2 === queue.dequeue())
      assert(queue.isEmpty === true)
    }
  }
}
