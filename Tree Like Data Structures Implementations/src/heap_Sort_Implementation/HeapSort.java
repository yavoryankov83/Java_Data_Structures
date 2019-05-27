package heap_Sort_Implementation;

public class HeapSort<T> {
  public <T extends Comparable<T>> void heapSort(T[] values) {

    //build heap (rearrange array)
    for (int index = values.length / 2 - 1; index >= 0; index--)
      heapify(values, values.length, index);

    //one by one extract an element from heap
    for (int index = values.length - 1; index >= 0; index--) {
      //move current root to end
      T temp = values[0];
      values[0] = values[index];
      values[index] = temp;

      //call max heapify on the reduced heap
      heapify(values, index, 0);
    }
  }

  //to heapify a subtree rooted with node i which is an index in the array and length is a size of heap
  private <T extends Comparable<T>> void heapify(T[] values, int length, int index) {
    int largestIndex = index; //initialize largest as root
    int leftChildIndex = 2 * index + 1; //left = 2*i + 1
    int rightChildIndex = 2 * index + 2; //right = 2*i + 2

    //MAX HEAP
    if (leftChildIndex < length && values[leftChildIndex].compareTo(values[largestIndex]) < 0) {
      largestIndex = leftChildIndex;
    }

//    //if left child is larger than root - MIN HEAP
//    if (leftChildIndex < length && values[leftChildIndex].compareTo(values[largestIndex]) > 0)
//      largestIndex = leftChildIndex;

    //MAX HEAP
    if (rightChildIndex < length && values[rightChildIndex].compareTo(values[largestIndex]) < 0) {
      largestIndex = rightChildIndex;
    }

//    //if right child is larger than largest so far - MIN HEAP
//    if (rightChildIndex < length && values[rightChildIndex].compareTo(values[largestIndex]) > 0)
//      largestIndex = rightChildIndex;

    //if largest is not root - swap root with largest so far
    if (largestIndex != index) {
      T swap = values[index];
      values[index] = values[largestIndex];
      values[largestIndex] = swap;

      //recursively heapify the affected sub-tree
      heapify(values, length, largestIndex);
    }
  }

  //function to print array
  public void printArray(T[] values) {

    for (T value : values) {
      System.out.print(value + " ");
    }
  }
}
