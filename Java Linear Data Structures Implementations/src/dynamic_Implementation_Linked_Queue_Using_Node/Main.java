package dynamic_Implementation_Linked_Queue_Using_Node;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    MyQueue<Integer> nums = new MyQueueImpl<>();

    nums.offer(1);
    nums.offer(2);
    nums.offer(3);
    nums.offer(4);

    Object[] integers = nums.toArray();

    System.out.println(Arrays.toString(integers)
            .replace('[', ' ')
            .replace(']', ' '));
  }
}
