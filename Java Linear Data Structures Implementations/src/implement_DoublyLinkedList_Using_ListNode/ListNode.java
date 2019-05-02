package implement_DoublyLinkedList_Using_ListNode;

public class ListNode<T> {

  private T value;
  private ListNode<T> previousNode;
  private ListNode<T> nextNode;

  public ListNode(T value) {
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

  public ListNode<T> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(ListNode<T> previousNode) {
    this.previousNode = previousNode;
  }

  public ListNode<T> getNextNode() {
    return this.nextNode;
  }

  public void setNextNode(ListNode<T> nextNode) {
    this.nextNode = nextNode;
  }
}
