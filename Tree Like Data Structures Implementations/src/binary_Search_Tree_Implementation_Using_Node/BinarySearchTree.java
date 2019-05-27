package binary_Search_Tree_Implementation_Using_Node;

public interface BinarySearchTree<T> {

  void add(T value);

  void remove(T value);

  boolean contains(T value);

  int size();

  boolean isEmpty();

  BinarySearchTree<T> search(T value);

  T minValue();

  T maxValue();

  void deleteMin();

  void deleteMax();

  Iterable<T> range(T start, T end);

  Iterable<T> recursive_inorder_DFS();

  Iterable<T> iterative_inorder_DFS();

  Iterable<T> recursive_postorder_DFS();

  Iterable<T> iterative_postorder_DFS();

  Iterable<T> recursive_preorder_DFS();

  Iterable<T> iterative_preorder_DFS();

  Node<T> delete(T value);
}
