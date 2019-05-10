package dynamic_Implementation_DoublyLinkedList_Using_Node;

import java.util.Iterator;

public interface MyDoublyLinkedList<T> {

  void addFirst(T value);

  void addLast(T value);

  void removeFirst();

  void removeLast();

  T getHead();

  T getTail();

  int size();

  boolean contains(T value);

  T[] toArray();

  Iterator<T> getIterator();
}
