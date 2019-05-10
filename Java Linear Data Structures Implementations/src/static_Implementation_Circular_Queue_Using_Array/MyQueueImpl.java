package static_Implementation_Circular_Queue_Using_Array;

import java.util.NoSuchElementException;

public class MyQueueImpl<T> implements MyQueqe<T> {

  private static final int CAPACITY = 4;
  private static final int RESIZE_MULTIPLIER = 2;
  private static final String NO_SUCH_ELEMENT_EXCEPTION = "no such element";

  private int size;
  private T[] data;
  private int startIndex; //pop and peek element from startIndex
  private int endIndex; //push element to endIndex

  public MyQueueImpl() {
    this.size = 0;
    this.data = (T[]) new Object[CAPACITY];
  }

  //O(1) Complexity
  @Override
  public void offer(T value) {
    if (this.size == this.data.length) {
      resize();
    }

    this.data[endIndex] = value;
    this.endIndex = (this.endIndex + 1) % this.data.length;
    this.size++;
  }

  //O(1) Complexity
  @Override
  public T poll() {
    if (this.size == 0) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPoll = this.data[this.startIndex];
    startIndex = (startIndex + 1) % this.data.length;
    size--;

    return elementToPoll;
  }

  //O(1) Complexity
  @Override
  public T peek() {
    if (this.size == 0) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPeek = this.data[this.startIndex];

    return elementToPeek;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  //O(n) Complexity
  @SuppressWarnings("uncheked")
  @Override
  public T[] toArray() {
    T[] newArray = (T[]) new Object[this.size];

    copyAllElements(newArray);

    return newArray;
  }

  private void resize() {
    T[] newArray = (T[]) new Object[this.data.length * RESIZE_MULTIPLIER];

    copyAllElements(newArray);

    this.data = newArray;

    this.startIndex = 0;
    this.endIndex = this.size;
  }

  private void copyAllElements(T[] newArray) {

    int currentIndex = 0;
    int currentStartIndex = this.startIndex;

    while (currentIndex < this.size) {
      newArray[currentIndex++] = this.data[currentStartIndex];
      currentStartIndex = (currentStartIndex + 1) % this.data.length;
    }
  }
}
