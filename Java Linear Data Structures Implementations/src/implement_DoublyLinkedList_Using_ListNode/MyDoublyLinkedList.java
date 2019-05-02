package implement_DoublyLinkedList_Using_ListNode;

import java.util.Iterator;

public interface MyDoublyLinkedList<T> {

  void addFirst(T value);

  void addLast(T value);

  void removeFirst();

  void removeLast();

  T getHead();

  T getTail();

  int size();

  T[] toArray();

  Iterator<T> getIterator();
}
