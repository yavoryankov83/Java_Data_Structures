package dynamic_Implementation_DoublyLinkedList_Using_Node;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    MyDoublyLinkedList nums = new MyDoublyLinkedListImpl();

    nums.addFirst(1);
    nums.addFirst(2);
    nums.addFirst(5);
    nums.addFirst(-2);

    System.out.println(nums.contains(22));

    Iterator iterator = nums.getIterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    Arrays.stream(nums.toArray()).forEach(x -> System.out.print(x + " "));
  }
}
