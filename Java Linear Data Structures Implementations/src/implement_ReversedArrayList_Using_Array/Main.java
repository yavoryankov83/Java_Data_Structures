package implement_ReversedArrayList_Using_Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    MyReversedArrayList<Integer> nums = new MyReversedArrayListImpl<>();
    nums.addElement(1);
    nums.addElement(2);
    nums.addElement(3);
    nums.addElement(87);
    nums.addElement(99);
    nums.addElement(4);

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
