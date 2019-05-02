package implement_ArrayList_Using_Array;

public class Main {
  public static void main(String[] args) {
    MyArrayList<Integer> nums = new MyArrayListImpl<>();

    nums.add(1);
    nums.add(2);
    nums.add(3);
    nums.add(4);
    nums.add(4);

    try {
      nums.removeAt(0);
      nums.removeAt(0);
      nums.removeAt(0);

      System.out.println(nums.getElement(2));
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }
}
