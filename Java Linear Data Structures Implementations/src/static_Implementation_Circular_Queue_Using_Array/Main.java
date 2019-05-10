package static_Implementation_Circular_Queue_Using_Array;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    MyQueqe<Integer> nums = new MyQueueImpl<>();

    nums.offer(2);
    nums.offer(5);
    nums.offer(78);
    nums.offer(45);
    nums.offer(0);

    Object[] integers = nums.toArray();

    for (Object integer : integers) {
      System.out.print(integer + " ");
    }

//    while (nums.getSize() > 0){
//      System.out.println(nums.poll());
//    }
  }
}
