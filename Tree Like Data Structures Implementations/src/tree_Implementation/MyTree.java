package tree_Implementation;

public interface MyTree<T> {

  Iterable<T> recursive_DFS();

  Iterable<T> iterative_DFS_Stack();

  Iterable<T> iterative_BFS_Queue();
}
