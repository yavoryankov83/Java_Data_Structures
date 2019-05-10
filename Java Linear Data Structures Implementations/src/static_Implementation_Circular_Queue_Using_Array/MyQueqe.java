package static_Implementation_Circular_Queue_Using_Array;

public interface MyQueqe<T> {

  void offer(T value);

  T poll();

  T peek();

  int getSize();

  T[] toArray();
}
