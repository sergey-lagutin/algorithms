package sc.collection.queues

trait Queue[T] {
  def enqueue(item: T)

  def dequeue(): T

  def isEmpty: Boolean
}
