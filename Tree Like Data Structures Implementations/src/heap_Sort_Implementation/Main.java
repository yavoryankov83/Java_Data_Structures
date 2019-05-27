package heap_Sort_Implementation;

public class Main {

  public static void main(String[] args) {
    Integer[] nums = {12, 11, 13, 5, 6, 7};

    HeapSort<Integer> heapSort = new HeapSort<>();

    heapSort.heapSort(nums);

    System.out.println("Sorted array is");
    heapSort.printArray(nums);
  }
}
