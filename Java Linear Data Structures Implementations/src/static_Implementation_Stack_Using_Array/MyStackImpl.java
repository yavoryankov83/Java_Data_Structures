package static_Implementation_Stack_Using_Array;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStackImpl<T> implements MyStack<T> {

  private static final int CAPACITY = 4;
  private static final String NO_SUCH_ELEMENT_EXCEPTION = "no such element";

  private int size;
  private T[] values;

  public MyStackImpl() {
    this.size = 0;
    this.values = (T[]) new Object[CAPACITY];
  }

  //O(1) Complexity
  @Override
  public void push(T value) {
    if (getSize() == this.values.length) {
      resizeArray();
    }

    values[size] = value;
    setSize(getSize() + 1);
  }

  private void resizeArray() {
    int newCapacity = this.values.length * 2;
    Arrays.copyOf(this.values, newCapacity);
  }

  //O(1) Complexity
  @Override
  public T pop() {
    if (getSize() == 0) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPop = this.values[getSize() - 1];
    setSize(getSize() - 1);
    this.values[getSize()] = null;

    return elementToPop;
  }

  //O(1) Complexity
  @Override
  public T peek() {
    if (getSize() == 0) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPop = this.values[getSize() - 1];

    return elementToPop;
  }

  @SuppressWarnings("uncheked")
  @Override
  public T[] toArray() {
    T[] newArray = (T[]) new Object[getSize()];

    int index = 0;

    while (getSize() > 0) {
      newArray[index] = this.pop();
      index++;
    }

    return newArray;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  //O(1) Complexity
  @Override
  public boolean isEmpty() {
    return getSize() == 0;
  }

  //O(n) Complexity
  @Override
  public int search(T value) {
    for (int i = 0; i < getSize(); i++) {
      if (this.values[i].equals(value)) {
        return i + 1;
      }
    }

    return -1;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
