package static_Implementation_ArrayList_Using_Array;

import java.util.Arrays;

public class MyArrayListImpl<T> implements MyArrayList<T> {

  private static final int RESIZE_ARRAY_MULTIPLIER = 2;
  private static final int SHRINKED_ARRAY_MULTIPLIER = 2;
  private static final String INDEX_OUT_OF_BOUNDS = "Index out of bounds";

  private T[] data;
  private int count;
  private int capacity;

  public MyArrayListImpl() {
    this.capacity = 2;
    this.count = 0;
    this.data = (T[]) new Object[this.capacity];
  }

  //O(1) Complexity
  @Override
  public T getElement(int index) {
    checkIndexValidity(index);

    return this.data[index];
  }

  //O(n) Complexity
  @Override
  public T setElement(int index, T value) {
    checkIndexValidity(index);

    return this.data[index] = value;
  }

  //O(1) Complexity
  @Override
  public void add(T element) {
    if (this.count == this.data.length) {
      resizeArray();
    }

    this.data[this.count++] = element;
  }

  //O(n) Complexity
  @Override
  public T removeAt(int index) {
    checkIndexValidity(index);

    T element = this.data[index];

    for (int i = index; i < this.count; i++) {
      this.data[i] = this.data[i + 1];
    }

    if (this.count <= this.data.length / 4) {
      shrink();
    }

    this.count--;
    return element;
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

  private void shrink() {
    T[] shrinkedArray;

    shrinkedArray = Arrays.copyOf(this.data, this.data.length / SHRINKED_ARRAY_MULTIPLIER);

    this.data = shrinkedArray;
  }

  private void checkIndexValidity(int index) {
    if (index < 0 || index >= this.count) {
      throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS);
    }
  }

  private void resizeArray() {
    T[] resizedArray;

    resizedArray = Arrays.copyOf(this.data, this.data.length * RESIZE_ARRAY_MULTIPLIER);

    this.data = resizedArray;
  }
}
