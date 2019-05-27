package priority_Queue_Implementation_Using_Binary_Heap;

public interface MyPriorityQueue<T> {

  void push(T value);

  T getTop();

  T pop();

  int size();
}
