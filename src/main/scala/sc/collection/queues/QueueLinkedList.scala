package sc.collection.queues


object QueueLinkedList {

  private class Node[T](val value: T) {
    var next: Node[T] = null
  }

}

class QueueLinkedList[T] extends Queue[T] {

  import QueueLinkedList.Node

  private var first: Node[T] = null
  private var last: Node[T] = null

  def enqueue(item: T) {
    val node = new Node[T](item)
    if (isEmpty) {
      first = node
      last = node
    }
    else {
      last.next = node
      last = node
    }
  }

  def dequeue(): T = {
    if (isEmpty) throw new RuntimeException

    val value = first.value
    first = first.next

    if (isEmpty) last = null

    value
  }

  def isEmpty: Boolean = first == null
}
