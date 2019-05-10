package dynamic_Implementation_Linked_Queue_Using_Node;

import java.util.NoSuchElementException;

public class MyQueueImpl<T> implements MyQueue<T> {

  private static final String NO_SUCH_ELEMENT_EXCEPTION = "no such element";

  private int size;
  private Node<T> head;
  private Node<T> tail;

  public MyQueueImpl() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  @Override
  public void offer(T value) {
    Node newNode = new Node(value);

    if (this.head == null) {
      this.head = newNode;
      this.tail = this.head;
    } else {
      this.tail.setNext(newNode);
      newNode.setPrevious(this.tail);
      this.tail = newNode;
    }

    this.size++;
  }

  @Override
  public T poll() {
    if (this.head == null) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPop = this.head.getValue();

    this.head = this.head.getNext();

    this.size--;

    return elementToPop;
  }

  @Override
  public T peek() {
    T elementToPeek = this.head.getValue();

    return elementToPeek;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public T[] toArray() {
    T[] newArray = (T[]) new Object[this.size];

    Node<T> tempHead = this.head;

    int index = 0;
    while (tempHead != null) {
      newArray[index++] = tempHead.getValue();
      tempHead = tempHead.getNext();
    }

    return newArray;
  }
}
