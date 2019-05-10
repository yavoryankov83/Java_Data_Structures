package dynamic_Implementation_Stack_Using_Node;

public class Main {
  public static void main(String[] args) {

    MyStack<Integer> nums = new MyStackImpl<>();

    nums.push(5);
    nums.push(8);
    nums.push(-2);
    nums.push(11);
    nums.push(6);

    System.out.println(nums.isEmpty());
    System.out.println(nums.search(5));

    Object[] integers = nums.toArray();

    for (Object integer : integers) {
      System.out.println(integer);
    }
  }
}
