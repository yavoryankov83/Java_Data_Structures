package static_Implementation_Stack_Using_Array;

public interface MyStack<T> {

  void push(T value);

  T pop();

  T peek();

  T[] toArray();

  int getSize();

  boolean isEmpty();

  int search(T value);
}
