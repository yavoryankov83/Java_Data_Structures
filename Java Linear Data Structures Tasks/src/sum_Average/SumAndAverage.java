package sum_Average;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAndAverage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read Integers and store in List
    List<Integer> nums = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());

    //map elements and use arithmetic functions
    int sum = nums.stream().mapToInt(Integer::intValue).sum();
    Double average = nums.stream().mapToInt(Integer::intValue).average().getAsDouble();

    String result = String.format("Sum=%d; Average=%.2f", sum, average);

    System.out.println(result);
  }
}
