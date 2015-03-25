package sc.collection.stacks

class StackArray[T >: Null](capacity: Int)(implicit m: Manifest[T]) extends Stack[T] {
  private final val data = new Array[T](capacity)
  private var n = 0

  def push(item: T) {
    data(n) = item
    n += 1
  }

  def pop(): T = {
    n -= 1
    val elem = data(n)
    data(n) = null
    elem
  }

  def isEmpty: Boolean = n == 0

}