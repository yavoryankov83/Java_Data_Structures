package tree_Implementation;

import java.util.*;

public class MyTreeImpl<T> implements MyTree<T> {

  private T value;
  private List<MyTreeImpl<T>> children;

  public MyTreeImpl(T value, MyTreeImpl<T>... children) {
    this.value = value;
    this.children = Arrays.asList(children);
  }

  @Override
  public Iterable<T> recursive_DFS() {
    List<T> resultValues = new ArrayList<>();

    traverseRecursiveDFS(this, resultValues);

    return resultValues;
  }

  private void traverseRecursiveDFS(MyTreeImpl<T> currentNode, List<T> result) {
    for (MyTreeImpl<T> child : currentNode.children) {
      traverseRecursiveDFS(child, result);
    }

    result.add(currentNode.value);
  }

  @Override
  public Iterable<T> iterative_DFS_Stack() {
    Deque<MyTreeImpl<T>> stack = new ArrayDeque<>();
    List<T> resultValues = new ArrayList<>();

    stack.addLast(this);

    while (!stack.isEmpty()) {
      MyTreeImpl<T> currentNode = stack.removeLast();

      for (MyTreeImpl<T> child : currentNode.children) {
        stack.addLast(child);
      }

      resultValues.add(currentNode.value);
    }

    Collections.reverse(resultValues);

    return resultValues;
  }

  @Override
  public Iterable<T> iterative_BFS_Queue() {
    Deque<MyTreeImpl<T>> queue = new ArrayDeque<>();
    List<T> resultValues = new ArrayList<>();

    queue.addLast(this);

    while (!queue.isEmpty()) {
      MyTreeImpl<T> currentNode = queue.removeFirst();
      resultValues.add(currentNode.value);

      for (MyTreeImpl<T> child : currentNode.children) {
        queue.addLast(child);
      }
    }

    return resultValues;
  }
}
