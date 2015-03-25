package sc.collection.stacks

class StackArrayResizing[T >: Null](implicit m: Manifest[T]) extends Stack[T] {
  private var n: Int = 0
  private var data: Array[T] = new Array[T](1)

  def push(item: T) {
    if (n == data.length) {
      resize(2 * data.length)
    }
    data(n) = item
    n += 1
  }

  private def resize(capacity: Int) {
    val copy = new Array[T](capacity)
    System.arraycopy(data, 0, copy, 0, n)
    data = copy
  }

  def pop(): T = {
    n -= 1
    val item = data(n)
    data(n) = null
    if (n > 0 && n == data.length / 4) {
      resize(data.length / 2)
    }
    item
  }

  def isEmpty: Boolean = n == 0


}