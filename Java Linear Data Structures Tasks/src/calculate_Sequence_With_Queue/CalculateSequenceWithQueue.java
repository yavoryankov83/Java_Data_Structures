package calculate_Sequence_With_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CalculateSequenceWithQueue {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int number = Integer.parseInt(reader.readLine());

    Deque<Integer> numbers = new ArrayDeque<>();
    int[] resultNumbers = new int[50];

    numbers.addLast(number);
    int index = 0;

    while (true) {
      int currentNumber = numbers.pollFirst();
      resultNumbers[index] = currentNumber;
      index++;

      if (index == 50) {
        break;
      }

      numbers.addLast(currentNumber + 1);
      numbers.addLast(2 * currentNumber + 1);
      numbers.addLast(currentNumber + 2);
    }

    System.out.println(Arrays.toString(resultNumbers)
            .replace('[', ' ')
            .replace(']', ' '));
  }
}
