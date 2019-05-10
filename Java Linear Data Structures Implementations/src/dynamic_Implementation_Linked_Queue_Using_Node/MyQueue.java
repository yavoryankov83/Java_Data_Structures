package dynamic_Implementation_Linked_Queue_Using_Node;

public interface MyQueue<T> {

  void offer(T value);

  T poll();

  T peek();

  int getSize();

  T[] toArray();
}
