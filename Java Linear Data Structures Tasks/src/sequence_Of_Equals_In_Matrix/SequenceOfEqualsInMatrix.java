package sequence_Of_Equals_In_Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceOfEqualsInMatrix {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int[] size = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    String[][] matrix = new String[size[0]][size[1]];

    int[] result = new int[4];

    for (int row = 0; row < matrix.length; row++) {
      String[] tokens = reader.readLine().split("\\s+");

      for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = tokens[col];
      }
    }

    result[0] = tryRows(matrix);
    result[1] = tryCols(matrix);
    result[2] = tryLeft_Right_Up_Down_Diagonal(matrix);
    result[3] = tryRight_Left_Down_Up_Diagonal(matrix);

    System.out.println(Arrays.stream(result).max().getAsInt());
  }

  private static int tryRows(String[][] matrix) {
    int longestSequenceOfEquals = Integer.MIN_VALUE;
    int currentLongestSequenceOfEquals = 1;

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length - 1; col++) {
        if (matrix[row][col].equals(matrix[row][col + 1])) {
          currentLongestSequenceOfEquals++;
        } else {
          longestSequenceOfEquals = Math.max(longestSequenceOfEquals, currentLongestSequenceOfEquals);
          currentLongestSequenceOfEquals = 1;
        }
      }
    }

    return longestSequenceOfEquals;
  }

  private static int tryCols(String[][] matrix) {
    int longestSequenceOfEquals = Integer.MIN_VALUE;
    int currentLongestSequenceOfEquals = 1;

    for (int col = 0; col < matrix[0].length; col++) {
      for (int row = 0; row < matrix.length - 1; row++) {
        if (matrix[row][col].equals(matrix[row + 1][col])) {
          currentLongestSequenceOfEquals++;
        } else {
          longestSequenceOfEquals = Math.max(longestSequenceOfEquals, currentLongestSequenceOfEquals);
          currentLongestSequenceOfEquals = 1;
        }
      }
    }

    for (int col = 0; col < matrix[0].length; col++) {
      for (int row = 0; row < matrix.length - 1; row++) {
        if (matrix[row][col].equals(matrix[row + 1][col])) {
          currentLongestSequenceOfEquals++;
        } else {
          longestSequenceOfEquals = Math.max(longestSequenceOfEquals, currentLongestSequenceOfEquals);
          currentLongestSequenceOfEquals = 1;
        }
      }
    }

    return longestSequenceOfEquals;
  }

  private static int tryLeft_Right_Up_Down_Diagonal(String[][] matrix) {
    int longestSequenceOfEquals = Integer.MIN_VALUE;
    int currentLongestSequenceOfEquals = 1;

    for (int i = 0; i < matrix[0].length - 1; i++) {
      if (matrix[i][i].equals(matrix[i + 1][i + 1])) {
        currentLongestSequenceOfEquals++;
      } else {
        longestSequenceOfEquals = Math.max(longestSequenceOfEquals, currentLongestSequenceOfEquals);
        currentLongestSequenceOfEquals = 1;
      }
    }

    return longestSequenceOfEquals;
  }

  private static int tryRight_Left_Down_Up_Diagonal(String[][] matrix) {
    int longestSequenceOfEquals = Integer.MIN_VALUE;
    int currentLongestSequenceOfEquals = 1;

    for (int i = 0; i < matrix[0].length - 1; i++) {
      if (matrix[i][matrix[0].length - i - 1].equals(matrix[i + 1][matrix[0].length - i - 1 - 1])) {
        currentLongestSequenceOfEquals++;
      } else {
        longestSequenceOfEquals = Math.max(longestSequenceOfEquals, currentLongestSequenceOfEquals);
        currentLongestSequenceOfEquals = 1;
      }
    }

    return longestSequenceOfEquals;
  }
}
