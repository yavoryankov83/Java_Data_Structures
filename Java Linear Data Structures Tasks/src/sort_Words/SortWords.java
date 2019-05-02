package sort_Words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortWords {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read Strings and store in List
    List<String> words = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .collect(Collectors.toList());

    //sort List
    Collections.sort(words);

    System.out.println(String.join(" ", words));
  }
}
