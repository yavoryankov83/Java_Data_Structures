package longest_Subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubsequence {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> nums = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

    int numberToRepeat = 0;
    int maxCount = 0;

    for (int i = 0; i < nums.size(); i++) {
      int currentCount = 1;

      for (int j = i + 1; j < nums.size(); j++) {
        if (nums.get(i).compareTo(nums.get(j)) == 0) {
          currentCount++;
        } else {
          break;
        }
      }

      if (currentCount > maxCount) {
        maxCount = currentCount;
        numberToRepeat = nums.get(i);
      }
    }

    for (int i = 0; i < maxCount; i++) {
      System.out.print(numberToRepeat + " ");
    }
  }
}
