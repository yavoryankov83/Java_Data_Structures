package static_Implementation_Stack_Using_Array;

public class Main {

  public static void main(String[] args) {
    MyStack<Integer> nums = new MyStackImpl<>();

    nums.push(5);
    nums.push(4);
    nums.push(56);
    nums.push(532);

    System.out.println(nums.isEmpty());
    System.out.println(nums.search(56));

    nums.pop();

    Object[] integers = nums.toArray();

    for (Object integer : integers) {
      System.out.println(integer);
    }
  }
}
