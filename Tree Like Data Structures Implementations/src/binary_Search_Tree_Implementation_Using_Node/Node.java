package binary_Search_Tree_Implementation_Using_Node;

public class Node<T> {

  private T value;
  private Node<T> left;
  private Node<T> right;
  private Node<T> parent;
  private int childrenCount;

  public Node(T value) {
    setValue(value);
    setLeft(null);
    setRight(null);
    setParent(null);
    setChildrenCount(1);
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

  public Node<T> getParent() {
    return parent;
  }

  public void setParent(Node<T> parent) {
    this.parent = parent;
  }

  public int getChildrenCount() {
    return childrenCount;
  }

  public void setChildrenCount(int childrenCount) {
    this.childrenCount = childrenCount;
  }

  @Override
  public String toString() {
    return this.getValue() + "";
  }
}
