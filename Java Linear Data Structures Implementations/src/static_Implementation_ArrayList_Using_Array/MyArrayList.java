package static_Implementation_ArrayList_Using_Array;

public interface MyArrayList<T> {

  T getElement(int index);

  T setElement(int index, T value);

  void add(T element);

  T removeAt(int index);

  boolean contains(T value);
}
