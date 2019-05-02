package implement_DoublyLinkedList_Using_ListNode;

import java.util.Iterator;

public class MyDoublyLinkedListImpl<T> implements MyDoublyLinkedList<T> {

  private ListNode<T> head;
  private ListNode<T> tail;
  private int size;

  public MyDoublyLinkedListImpl() {
    setHead(null);
    setTail(null);
    setSize(0);
  }

  //O(1) Complexity
  @Override
  public void addFirst(T value) {
    this.size++;

    ListNode<T> newNode = new ListNode<>(value);

    //check if list is empty
    if (this.head == null) {
      setHead(newNode);
      setTail(newNode);

      return;
    }

    //check if list is not empty
    newNode.setNextNode(this.head);
    this.head.setPreviousNode(newNode);
    setHead(newNode);
  }

  //O(1) Complexity
  @Override
  public void addLast(T value) {
    this.size++;

    ListNode<T> newNode = new ListNode<>(value);

    //check if list is empty
    if (this.tail == null) {
      setTail(newNode);
      setHead(newNode);

      return;
    }

    //chech if list is not empty
    this.tail.setNextNode(newNode);
    newNode.setPreviousNode(this.tail);
    setTail(newNode);
  }

  //O(1) Complexity
  @Override
  public void removeFirst() {
    this.size--;

    if (this.head.getNextNode() != null) {
      this.head.getNextNode().setPreviousNode(null);
    }

    setHead(this.head.getNextNode());
  }

  //O(1) Complexity
  @Override
  public void removeLast() {
    this.size--;

    if (this.tail.getPreviousNode() != null) {
      this.tail.getPreviousNode().setNextNode(null);
      setTail(this.tail.getPreviousNode());
    }
  }

  //O(1) Complexity
  @Override
  public T getHead() {
    return this.head.getValue();
  }

  //O(1) Complexity
  @Override
  public T getTail() {
    return this.tail.getValue();
  }

  @Override
  public int size() {
    return getSize();
  }

  public void setHead(ListNode<T> head) {
    this.head = head;
  }

  public void setTail(ListNode<T> tail) {
    this.tail = tail;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public Iterator<T> getIterator() {
    return new MyLinkedListIterator<>(this.head);
  }

  private class MyLinkedListIterator<T> implements Iterator<T> {

    private ListNode<T> node;

    public MyLinkedListIterator(ListNode<T> node) {
      this.node = node;
    }

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public T next() {
      T value = this.node.getValue();
      this.node = this.node.getNextNode();

      return value;
    }
  }

  @Override
  public T[] toArray() {

    T[] result = (T[]) new Object[getSize()];

    ListNode newNode = head;

    int currentIndex = 0;

    while (currentIndex < getSize()) {
      result[currentIndex] = (T) newNode.getValue();
      currentIndex++;
      newNode = newNode.getNextNode();

    }
    return result;
  }
}
