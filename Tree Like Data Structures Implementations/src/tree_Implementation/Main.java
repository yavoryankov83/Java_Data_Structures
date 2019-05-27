package tree_Implementation;

public class Main {

  public static void main(String[] args) {
    MyTreeImpl<Integer> myTree =
            new MyTreeImpl<>(7,
                    new MyTreeImpl<>(19,
                            new MyTreeImpl<>(1),
                            new MyTreeImpl<>(12),
                            new MyTreeImpl<>(31)),
                    new MyTreeImpl<>(21),
                    new MyTreeImpl<>(14,
                            new MyTreeImpl<>(23),
                            new MyTreeImpl<>(6)));

    Iterable<Integer> recursive_DFS = myTree.recursive_DFS();

    for (Integer integer : recursive_DFS) {
      System.out.print(integer + " ");
    }
    System.out.println();
    System.out.println("=============================================");

    Iterable<Integer> iterative_BFS_Queue = myTree.iterative_BFS_Queue();

    for (Integer integer : iterative_BFS_Queue) {
      System.out.print(integer + " ");
    }
    System.out.println();
    System.out.println("----------------------------------------------");

    Iterable<Integer> iterative_DFS_Stack = myTree.iterative_DFS_Stack();

    for (Integer integer : iterative_DFS_Stack) {
      System.out.print(integer + " ");
    }
  }
}
