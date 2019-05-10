package matching_Brackets_Using_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingBrackets {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> stack = new ArrayDeque();

    //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
    String expression = reader.readLine();
    char[] expressionAsChar = expression.toCharArray();

    for (int i = 0; i < expressionAsChar.length; i++) {
      if (expressionAsChar[i] == '(') {
        stack.addLast(i);
      } else if (expressionAsChar[i] == ')') {
        System.out.println(expression.substring(stack.pollLast(), i + 1));
      }
    }
  }
}
