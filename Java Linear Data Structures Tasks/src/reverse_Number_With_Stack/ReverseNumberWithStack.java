package reverse_Number_With_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ReverseNumberWithStack {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int[] nums = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    Deque<Integer> reversedNums = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {
      reversedNums.addLast(nums[i]);
    }

    while (reversedNums.size() > 0) {
      System.out.print(reversedNums.pollLast() + " ");
    }
  }
}
