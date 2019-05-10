package static_Implementation_ReversedArrayList_Using_Array;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {

    MyReversedArrayList<Integer> nums = new MyReversedArrayListImpl<>();
    nums.addElement(1);
    nums.addElement(2);
    nums.addElement(3);
    nums.addElement(87);
    nums.addElement(99);
    nums.addElement(4);

    System.out.println(nums.contains(999));

    try {
      System.out.println(nums.getElement(2));
      nums.setElement(25, 89);
      System.out.println(nums.getElement(2));
      nums.removeAt(2);

      Iterator<Integer> iterator = nums.getIterator();

      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
    } catch (IndexOutOfBoundsException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
