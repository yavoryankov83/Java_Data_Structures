package binary_Search_Tree_Implementation_Using_Node;

public class Main {

  public static void main(String[] args) {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTreeImpl<>();

    binarySearchTree.add(5);
    binarySearchTree.add(3);
    binarySearchTree.add(1);
    binarySearchTree.add(10);
    binarySearchTree.add(100);

    System.out.println(binarySearchTree.contains(3));
    System.out.println(binarySearchTree.contains(33));

    binarySearchTree.recursive_inorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();
    binarySearchTree.iterative_inorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();

    binarySearchTree.recursive_postorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();
    binarySearchTree.iterative_postorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();

    binarySearchTree.recursive_preorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();
    binarySearchTree.iterative_preorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();

    System.out.println(binarySearchTree.minValue());
    System.out.println(binarySearchTree.maxValue());

    binarySearchTree.deleteMin();
    binarySearchTree.deleteMax();

    binarySearchTree.recursive_inorder_DFS().forEach(x -> System.out.print(x + " "));
    System.out.println();
  }
}
