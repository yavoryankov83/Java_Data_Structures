package static_Implementation_ReversedArrayList_Using_Array;

import java.util.Arrays;
import java.util.Iterator;

public class MyReversedArrayListImpl<T> implements MyReversedArrayList<T> {

  private static final String INDEX_OUT_OF_BOUNDS = "Index is out of bounds";
  private static final int RESIZE_ARRAY_MULTIPLIER = 2;

  private int capacity;
  private int count;
  private T[] data;

  public MyReversedArrayListImpl() {
    this.capacity = 2;
    this.count = 0;
    this.data = (T[]) new Object[this.capacity];
  }

  //O(1) Complexity
  @Override
  public void addElement(T element) {
    if (this.count == this.data.length) {
      resize();
    }

    this.data[count++] = element;
  }

  //O(n) Complexity
  @Override
  public T removeAt(int index) {
    checkIndexValidity(index);

    T element = this.data[this.count - 1 - index];

    for (int i = this.count - 1 - index; i < this.count - 1; i++) {
      this.data[i] = this.data[i + 1];
    }

    this.count--;
    this.data = (T[]) Arrays.stream(this.data).limit(count).toArray();
    return element;
  }

  //O(1) Complexity
  @Override
  public T getElement(int index) {
    checkIndexValidity(index);

    T element = this.data[this.count - 1 - index];

    return element;
  }

  //O(n) Complexity
  @Override
  public void setElement(int index, T element) {
    checkIndexValidity(index);

    this.data[this.count - 1 - index] = element;
  }

  //O(n) Complexity
  @Override
  public boolean contains(T value) {
    for (int i = 0; i < this.count; i++) {
      if (this.data[i].equals(value)) {
        return true;
      }
    }

    return false;
  }

  private void checkIndexValidity(int index) {
    if (index < 0 || index > this.count) {
      throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS);
    }
  }

  private void resize() {
    T[] resizedArray;

    resizedArray = Arrays.copyOf(this.data, this.data.length * RESIZE_ARRAY_MULTIPLIER);

    this.data = resizedArray;
  }

  @Override
  public Iterator<T> getIterator() {
    return new MyReversedArrayListIterator();
  }

  private class MyReversedArrayListIterator implements Iterator<T> {

    private int count;

    @Override
    public boolean hasNext() {
      return this.count < data.length;
    }

    @Override
    public T next() {
      return data[data.length - 1 - count++];
    }
  }
}
