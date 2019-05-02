package count_Of_Occurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOfOccurrences {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int[] nums = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    Map<Integer, Integer> occurrences = new HashMap<>();

    for (int num : nums) {
      if (!occurrences.containsKey(num)) {
        occurrences.put(num, 0);
      }

      occurrences.put(num, occurrences.get(num) + 1);
    }

    for (Map.Entry<Integer, Integer> integerIntegerEntry : occurrences.entrySet()) {
      System.out.println(String.format("%d -> %d times", integerIntegerEntry.getKey(), integerIntegerEntry.getValue()));
    }
  }
}
