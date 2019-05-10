package dynamic_Implementation_Stack_Using_Node;

public interface MyStack<T> {

  void push(T value);

  T pop();

  T peek();

  boolean isEmpty();

  int search(T value);

  T[] toArray();
}
