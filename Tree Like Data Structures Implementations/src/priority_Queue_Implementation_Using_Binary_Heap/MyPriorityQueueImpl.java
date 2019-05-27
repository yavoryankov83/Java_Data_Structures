package priority_Queue_Implementation_Using_Binary_Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyPriorityQueueImpl<T extends Comparable<T>> implements MyPriorityQueue<T> {

  //parentIndex = (index - 1) / 2
  //leftChildIndex = index * 2 + 1
  //rightChildIndex = index * 2 + 2

  private static final String PRIORITY_QUEUE_IS_EMPTY = "The priorityqueqe is empty";
  private int size;
  private List<T> values;

  public MyPriorityQueueImpl() {
    this.values = new ArrayList<>();
  }

  @Override
  public int size() {
    return this.size;
  }

  //complexity O(1)
  @Override
  public void push(T value) {
    this.values.add(value);

//    heapifyUp_Iterative();

    int currentIndex = this.values.size() - 1;
    heapifyUp_Recursive(value, currentIndex);

    this.size++;
  }

  private void heapifyUp_Iterative() {
    int currentIndex = this.values.size() - 1;

    while (currentIndex >= 0) {
      int parentIndex = (currentIndex - 1) / 2;

      //check if index is valid
      if (parentIndex < 0) {
        return;
      }

      T parentValue = this.values.get(parentIndex);
      T value = this.values.get(currentIndex);

      int compare = parentValue.compareTo(value);

//      //MAX HEAP
//      if (compare < 0){
//        swap(currentIndex, parentIndex);
//        currentIndex = parentIndex;
//      } else {
//        break;
//      }

      //MIN HEAP
      if (compare > 0) {
        swap(currentIndex, parentIndex);
        currentIndex = parentIndex;
      } else {
        break;
      }
    }
  }

  private void heapifyUp_Recursive(T value, int currentIndex) {
    int parentIndex = (currentIndex - 1) / 2;

    //check if index is valid
    if (parentIndex < 0) {
      return;
    }

    T parentValue = this.values.get(parentIndex);

    int compare = this.values.get(parentIndex).compareTo(this.values.get(currentIndex));

    //MIN HEAP
    if (compare > 0) {
      swap(currentIndex, parentIndex);
      heapifyUp_Recursive(parentValue, parentIndex);
    }
  }

  private void swap(int parentIndex, int currentIndex) {
    T temp = this.values.get(parentIndex);
    this.values.set(parentIndex, this.values.get(currentIndex));
    this.values.set(currentIndex, temp);
  }

  //complexity O(1)
  @Override
  public T getTop() {
    if (this.values.size() == 0) {
      throw new NoSuchElementException(PRIORITY_QUEUE_IS_EMPTY);
    }

    return this.values.get(0);
  }

  //complexity O(log n)
  @Override
  public T pop() {
    if (this.values.size() == 0) {
      throw new NoSuchElementException(PRIORITY_QUEUE_IS_EMPTY);
    }

    T valueToReturn = this.getTop();

    T value = this.values.get(this.values.size() - 1);
    values.set(0, value);
    values.remove(this.values.size() - 1);

    heapifyDown_Iterative();

    this.size--;

    return valueToReturn;
  }

  private void heapifyDown_Iterative() {
    int currentIndex = 0;

    while (true) {
      int greaterChildIndex = getGreaterChildIndex(currentIndex);

      //check if index is valid
      if (greaterChildIndex < 0) {
        break;
      }

      T greaterChildValue = this.values.get(greaterChildIndex);

      //compare greater value and current value
//      //MAX HEAP
//      int compare = this.values.get(currentIndex).compareTo(greaterChildValue);
//      if (compare < 0){
//        swap(currentIndex, greaterChildIndex);
//        currentIndex = greaterChildIndex;
//      } else {
//        break;
//      }

      //MIX HEAP
      int compare = this.values.get(currentIndex).compareTo(greaterChildValue);
      if (compare > 0) {
        swap(currentIndex, greaterChildIndex);
        currentIndex = greaterChildIndex;
      } else {
        break;
      }
    }
  }

  private int getGreaterChildIndex(int currentIndex) {
    int leftChildIndex = currentIndex * 2 + 1;
    int rightChildIndex = currentIndex * 2 + 2;

    //check for left child
    if (leftChildIndex > this.values.size() - 1) {
      return -1;
    }

    //check for right child
    if (rightChildIndex > this.values.size() - 1) {
      return leftChildIndex;
    }

    //set greater value to the left child value
    T greaterChildValue = this.values.get(leftChildIndex);

    //set greater index to the leftchild index
    int greaterChildIndex = leftChildIndex;


    //check if value of right child is greater then greater value
//    //MAX HEAP
//    if (greaterChildValue.compareTo(this.values.get(rightChildIndex)) < 0){
//      greaterChildIndex = rightChildIndex;
//    }

    //MIN HEAP
    if (greaterChildValue.compareTo(this.values.get(rightChildIndex)) > 0) {
      greaterChildIndex = rightChildIndex;
    }

    return greaterChildIndex;
  }
}
