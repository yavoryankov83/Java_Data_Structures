package implement_DoublyLinkedList_Using_ListNode;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    MyDoublyLinkedList nums = new MyDoublyLinkedListImpl();

    nums.addFirst(1);
    nums.addFirst(2);
    nums.addFirst(5);
    nums.addFirst(-2);

    Iterator iterator = nums.getIterator();

    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }

    Arrays.stream(nums.toArray()).forEach(x -> System.out.print(x + " "));
  }
}
