package static_Implementation_ReversedArrayList_Using_Array;

import java.util.Iterator;

public interface MyReversedArrayList<T> {

  void addElement(T element);

  T removeAt(int index);

  T getElement(int index);

  void setElement(int index, T element);

  boolean contains(T value);

  Iterator<T> getIterator();
}