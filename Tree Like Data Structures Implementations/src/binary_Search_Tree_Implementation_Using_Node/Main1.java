package binary_Search_Tree_Implementation_Using_Node;

public class Main1 {

  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTreeImpl<>();

//    bst.add(8);
//    bst.add(3);
//    bst.add(6);
//    bst.add(10);
//    bst.add(4);
//    bst.add(7);
//    bst.add(1);
//    bst.add(14);
//    bst.add(13);
//
//    bst.myDelete(6);
//
//    System.out.println(bst.recursive_inorder_DFS());

    bst.add(5);
    bst.add(2);
    bst.add(1);
    bst.add(3);
    bst.add(12);
    bst.add(9);
    bst.add(21);
    bst.add(19);
    bst.add(25);

    bst.delete(12);

    System.out.println(bst.recursive_inorder_DFS());
  }
}
