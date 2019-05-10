package dynamic_Implementation_DoublyLinkedList_Using_Node;

public class Node<T> {

  private T value;
  private Node<T> previousNode;
  private Node<T> nextNode;

  public Node(T value) {
    setValue(value);
    setPreviousNode(null);
    setNextNode(null);
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(Node<T> previousNode) {
    this.previousNode = previousNode;
  }

  public Node<T> getNextNode() {
    return this.nextNode;
  }

  public void setNextNode(Node<T> nextNode) {
    this.nextNode = nextNode;
  }
}
