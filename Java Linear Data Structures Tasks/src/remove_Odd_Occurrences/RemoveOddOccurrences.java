package remove_Odd_Occurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveOddOccurrences {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> nums = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

    Map<Integer, Integer> result = new LinkedHashMap<>();

    for (int i = 0; i < nums.size(); i++) {
      if (!result.containsKey(nums.get(i))) {
        result.put(nums.get(i), 0);
      }

      result.put(nums.get(i), result.get(nums.get(i)) + 1);
    }

    for (int i = 0; i < nums.size(); i++) {
      if (result.get(nums.get(i)) % 2 == 0) {
        System.out.print(nums.get(i) + " ");
      }
    }
  }
}
