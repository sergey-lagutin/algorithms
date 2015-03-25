package sc.collection.stacks

object StackLinkedList {

  private class Node[T](val item: T, val next: Node[T]) {
  }

}

class StackLinkedList[T] extends Stack[T] {

  import StackLinkedList.Node

  private var first: Node[T] = null

  def push(item: T) {
    first = new Node[T](item, first)
  }

  def pop(): T = {
    val item = first.item
    first = first.next
    item
  }

  def isEmpty: Boolean = first == null
}