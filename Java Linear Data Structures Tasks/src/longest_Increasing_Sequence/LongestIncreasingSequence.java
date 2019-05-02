package longest_Increasing_Sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSequence {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int[] nums = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    int maxCount = Integer.MIN_VALUE;
    int currentCount = 1;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] > nums[i]) {
        currentCount++;
      } else {
        maxCount = Math.max(maxCount, currentCount);
        currentCount = 1;
      }
    }

    System.out.println(maxCount);
  }
}
