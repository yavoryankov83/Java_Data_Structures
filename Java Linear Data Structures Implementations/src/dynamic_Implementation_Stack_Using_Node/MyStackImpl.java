package dynamic_Implementation_Stack_Using_Node;

import java.util.NoSuchElementException;

public class MyStackImpl<T> implements MyStack<T> {

  private static String NO_SUCH_ELEMENT_EXCEPTION = "No such element";

  private int size;
  private Node<T> top;

  //O(1) Complexity
  @Override
  public void push(T value) {
    setTop(new Node<>(value, getTop()));

    size++;
  }

  //O(1) Complexity
  @Override
  public T pop() {
    if (getSize() == 0) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPop = getTop().getValue();
    setTop(getTop().getNext());

    size--;

    return elementToPop;
  }

  //O(1) Complexity
  @Override
  public T peek() {
    if (getSize() == 0) {
      throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    T elementToPeek = getTop().getValue();

    return elementToPeek;
  }

  //O(1) Complexity
  @Override
  public boolean isEmpty() {
    return getSize() == 0;
  }

  //O(n) Complexity
  @Override
  public int search(T value) {
    Node<T> current = getTop();

    int currentIndex = getSize();

    while (current != null) {
      if (current.getValue().equals(value)) {
        return currentIndex;
      }

      current = current.getNext();
      currentIndex--;
    }

    return -1;
  }

  @Override
  public T[] toArray() {

    @SuppressWarnings("uncheked")
    T[] newArray = (T[]) new Object[getSize()];

    Node<T> currentNode = getTop();
    int index = 0;

    while (currentNode != null) {
      newArray[index++] = currentNode.getValue();
      currentNode = currentNode.getNext();
    }

    return newArray;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Node<T> getTop() {
    return top;
  }

  public void setTop(Node<T> top) {
    this.top = top;
  }
}
