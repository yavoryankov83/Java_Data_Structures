package binary_Search_Tree_Implementation_Using_Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private Node<T> root;
  private int size;

  public BinarySearchTreeImpl() {
    this.root = null;
    this.size = 0;
  }

  public BinarySearchTreeImpl(Node<T> root) {
    preorderCopy(root);
  }

  private void preorderCopy(Node<T> node) {
    if (node == null) {
      return;
    }

    add(node.getValue());
    preorderCopy(node.getLeft());
    preorderCopy(node.getRight());
  }

  @Override
  public void add(T value) {
    Node<T> nodeToAdd = new Node<>(value);

    if (this.root == null) {
      this.root = nodeToAdd;
      return;
    }

    Node<T> currentNode = this.root;
    Node<T> parentNode = null;

    //iterative variant 1
//    while (currentNode != null){
//      int compare = value.compareTo(currentNode.getValue());
//
//      if (compare < 0){
//        parentNode = currentNode;
//        currentNode = currentNode.getLeft();
//      } else {
//        parentNode = currentNode;
//        currentNode = currentNode.getRight();
//      }
//    }
//
//    if (parentNode.getValue().compareTo(value) > 0){
//      parentNode.setLeft(nodeToAdd);
//    } else {
//      parentNode.setRight(nodeToAdd);
//    }

    //iterative variant 2
//    while (true){
//      if (nodeToAdd.getValue().compareTo(currentNode.getValue()) < 0){
//        //go left from current node
//        if (currentNode.getLeft() == null){
//          //there is no left node
//          currentNode.setLeft(nodeToAdd);
//          break;
//        }
//
//        currentNode = currentNode.getLeft();
//      } else {
//        //go right from current node
//        if (currentNode.getRight() == null){
//          //there is no right node
//          currentNode.setRight(nodeToAdd);
//          break;
//        }
//
//        currentNode = currentNode.getRight();
//      }
//    }

    //recursive variant
    insertTraverse(root, value);
  }

  private void insertTraverse(Node<T> node, T value) {
    //to avoid adding duplicates we need this check
//    if (value.compareTo(node.getValue()) == 0){
//      return;
//    }
    if (value.compareTo(node.getValue()) < 0) {
      //go left
      if (node.getLeft() == null) {
        Node<T> newNode = new Node<>(value);
        node.setLeft(newNode);
        newNode.setParent(node);
        return;
      }
      insertTraverse(node.getLeft(), value);
    } else {
      //go right
      if (node.getRight() == null) {
        Node<T> newNode = new Node<>(value);
        node.setRight(newNode);
        newNode.setParent(node);
        return;
      }
      insertTraverse(node.getRight(), value);
    }
  }

  @Override
  public void remove(T value) {
    if (!contains(value)) {
      return;
    }

    Node<T> nodeToRemove = findNode(this.root, value);
    Node<T> nodeReplacement = findSmallestLarger(value, nodeToRemove);

    if (nodeReplacement == null) {
      if (nodeToRemove.getValue().compareTo(nodeToRemove.getParent().getValue()) < 0) {
        nodeToRemove.setLeft(null);
      } else {
        nodeToRemove.setRight(null);
      }

      return;
    }

    nodeToRemove.setValue(nodeReplacement.getValue());

    nodeReplacement.getParent().setLeft(nodeToRemove.getRight());

    if (nodeToRemove.getRight() != null) {
      nodeReplacement.getRight().setParent(nodeReplacement.getParent());
    }
  }

  private Node<T> findSmallestLarger(T value, Node<T> node) {
    if (node.getRight() == null) {
      return null;
    }

    node = node.getRight();

    //find replacement node - one time right and then go left till node is not null
    while (node.getLeft() != null) {
      node = node.getLeft();
    }

    return node;
  }

  private Node<T> findNode(Node<T> node, T value) {
    if (value.compareTo(node.getValue()) == 0) {
      return node;
    }

    if (value.compareTo(node.getValue()) < 0) {
      return findNode(node.getLeft(), value);
    } else {
      return findNode(node.getRight(), value);
    }

  }

  @Override
  public boolean contains(T value) {
    return containsTraverse(this.root, value);
  }

  private boolean containsTraverse(Node<T> node, T value) {
    if (node == null) {
      return false;
    }

    if (node.getValue().compareTo(value) == 0) {
      return true;
    }

    if (value.compareTo(node.getValue()) < 0) {
      return containsTraverse(node.getLeft(), value);
    } else {
      return containsTraverse(node.getRight(), value);
    }
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.root == null;
  }

  @Override
  public BinarySearchTree<T> search(T value) {
    Node<T> currentNode = this.root;

    int compare = value.compareTo(currentNode.getValue());

    while (currentNode != null) {
      if (compare < 0) {
        currentNode = currentNode.getLeft();
      } else if (compare > 0) {
        currentNode = currentNode.getRight();
      } else {
        break;
      }
    }


    return new BinarySearchTreeImpl<>(currentNode);
  }

  @Override
  public T minValue() {
    Node<T> currentNode = this.root;

    T minValue = currentNode.getValue();

    while (currentNode.getLeft() != null) {
      minValue = currentNode.getLeft().getValue();
      currentNode = currentNode.getLeft();
    }

    return minValue;
  }

  @Override
  public T maxValue() {
    Node<T> currentNode = this.root;

    T maxValue = currentNode.getValue();

    while (currentNode.getRight() != null) {
      maxValue = currentNode.getRight().getValue();
      currentNode = currentNode.getRight();
    }

    return maxValue;
  }

  @Override
  public void deleteMin() {
    if (this.root != null) {

      Node<T> minNode = this.root;
      Node<T> parentNode = null;

      while (minNode.getLeft() != null) {
        parentNode = minNode;
        parentNode.setChildrenCount(parentNode.getChildrenCount() - 1);
        minNode = minNode.getLeft();
      }

      if (parentNode == null) {
        this.root = this.root.getRight();
      } else {
        parentNode.setLeft(minNode.getRight());
      }

      this.size--;
    } else {
      return;
    }
  }

  @Override
  public void deleteMax() {
    if (this.root != null) {
      Node<T> maxNode = this.root;
      Node<T> parentNode = null;


      while (maxNode.getRight() != null) {
        parentNode = maxNode;
        parentNode.setChildrenCount(parentNode.getChildrenCount() - 1);
        maxNode = maxNode.getRight();
      }

      if (parentNode == null) {
        this.root = this.root.getLeft();
      } else {
        parentNode.setRight(maxNode.getLeft());
      }

      this.size--;
    }
  }

  @Override
  public Iterable<T> range(T start, T end) {
    Deque<T> resultValues = new ArrayDeque<>();

    range(this.root, resultValues, start, end);

    return resultValues;
  }

  private void range(Node<T> node, Deque<T> resultValues, T start, T end) {
    if (node == null) {
      return;
    }

    int compareStart = node.getValue().compareTo(start);
    int compareEnd = node.getValue().compareTo(start);

    if (compareStart > 0) {
      range(node.getLeft(), resultValues, start, end);
    }
    //chech if node value is in range ant if it is add to collection
    if (compareStart >= 0 && compareEnd <= 0) {
      resultValues.addLast(node.getValue());
    }
    if (compareEnd < 0) {
      this.range(node.getRight(), resultValues, start, end);
    }
  }

  @Override
  public Iterable<T> recursive_inorder_DFS() {
    List<T> resultValues = new ArrayList<>();

    traverseInorderDFS(this.root, resultValues);

    return resultValues;
  }

  private void traverseInorderDFS(Node<T> node, List<T> resultValues) {
    if (node == null) {
      return;
    }
    traverseInorderDFS(node.getLeft(), resultValues);

    resultValues.add(node.getValue());

    traverseInorderDFS(node.getRight(), resultValues);
  }

  @Override
  public Iterable<T> iterative_inorder_DFS() {
    List<T> resultValues = new ArrayList<>();

    traverseInorderIterativeDFS(this.root, resultValues);

    return resultValues;
  }

  private void traverseInorderIterativeDFS(Node<T> node, List<T> resultValues) {
    Deque<Node<T>> stack = new ArrayDeque<>();

    if (node != null) {
      Node<T> currentNode = this.root;

      while (currentNode != null || !stack.isEmpty()) {
        while (currentNode != null) {
          stack.addLast(currentNode);
          currentNode = currentNode.getLeft();
        }

        currentNode = stack.removeLast();

        resultValues.add(currentNode.getValue());

        currentNode = currentNode.getRight();
      }
    }
  }

  @Override
  public Iterable<T> recursive_postorder_DFS() {
    List<T> resultValues = new ArrayList<>();

    traversePostorderDFS(this.root, resultValues);


    return resultValues;
  }

  private void traversePostorderDFS(Node<T> node, List<T> resultValues) {
    if (node == null) {
      return;
    }

    traversePostorderDFS(node.getLeft(), resultValues);

    traversePostorderDFS(node.getRight(), resultValues);

    resultValues.add(node.getValue());
  }

  @Override
  public Iterable<T> iterative_postorder_DFS() {
    List<T> resultValues = new ArrayList<>();

    traversePostorderIterativeDFS(this.root, resultValues);

    return resultValues;
  }

  private void traversePostorderIterativeDFS(Node<T> node, List<T> resultValues) {
    Deque<Node<T>> stack_1 = new ArrayDeque<>();
    Deque<Node<T>> stack_2 = new ArrayDeque<>();

    if (node != null) {
      stack_1.addLast(this.root);

      while (!stack_1.isEmpty()) {
        Node<T> currentNode = stack_1.removeLast();
        stack_2.addLast(currentNode);

        if (currentNode.getLeft() != null) {
          stack_1.addLast(currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
          stack_1.addLast(currentNode.getRight());
        }
      }

      while (!stack_2.isEmpty()) {
        resultValues.add(stack_2.removeLast().getValue());
      }
    }
  }

  @Override
  public Iterable<T> recursive_preorder_DFS() {
    List<T> resultValues = new ArrayList<>();

    traversePreorderDFS(this.root, resultValues);

    return resultValues;
  }

  private void traversePreorderDFS(Node<T> node, List<T> resultValues) {
    if (node == null) {
      return;
    }

    resultValues.add(node.getValue());

    traversePreorderDFS(node.getLeft(), resultValues);

    traversePreorderDFS(node.getRight(), resultValues);
  }

  @Override
  public Iterable<T> iterative_preorder_DFS() {
    List<T> resultValues = new ArrayList<>();

    traversePreorderIterativeDFS(this.root, resultValues);

    return resultValues;
  }

  private void traversePreorderIterativeDFS(Node<T> node, List<T> resultValues) {
    Deque<Node<T>> stack = new ArrayDeque<>();

    if (node != null) {
      stack.addLast(this.root);

      while (!stack.isEmpty()) {
        Node<T> currentNode = stack.removeLast();
        resultValues.add(currentNode.getValue());

        if (currentNode.getRight() != null) {
          stack.addLast(currentNode.getRight());
        }

        if (currentNode.getLeft() != null) {
          stack.addLast(currentNode.getLeft());
        }
      }
    }
  }

  @Override
  public Node<T> delete(T value) {
    Node<T> current = this.root;

    return traversedelete(current, value);
  }

  private Node<T> traversedelete(Node<T> currentNode, T value) {
    //check if root is null
    if (currentNode == null) {
      return null;
    }

    int compare = value.compareTo(currentNode.getValue());

    //go left
    if (compare < 0) {
      currentNode.setLeft(traversedelete(currentNode.getLeft(), value));
      //go right
    } else if (compare > 0) {
      currentNode.setRight(traversedelete(currentNode.getRight(), value));
    } else {
      //node to remove is found

      //case 1: node with no child
      if (currentNode.getLeft() == null && currentNode.getRight() == null) {
        currentNode = null;

        //case 2: node with left ot right child
      } else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
        Node<T> temp = currentNode;
        temp = currentNode.getLeft() == null ? currentNode.getRight() : currentNode.getLeft();

        currentNode = temp;

        //case 3: node with left and right child
      } else {

        //findMinNodeOnRight - first variant
        Node<T> temp = findMinNodeOnRight(currentNode.getRight());
        currentNode.setValue(temp.getValue());
        currentNode.setRight(traversedelete(currentNode.getRight(), temp.getValue()));

        //findMaxNodeOnLeft - second variant
//        Node<T> temp = findMaxNodeOnLeft(currentNode.getLeft());
//        currentNode.setValue(temp.getValue());
//        currentNode.setLeft(traverseMyDelete(currentNode.getLeft(), temp.getValue()));
      }
    }

    return currentNode;
  }

  private Node<T> findMaxNodeOnLeft(Node<T> leftNode) {
    if (leftNode == null) {
      return null;
    }

    Node<T> temp = leftNode;

    while (temp.getRight() != null) {
      temp = temp.getRight();
    }

    return temp;
  }

  private Node<T> findMinNodeOnRight(Node<T> rightNode) {
    if (rightNode == null) {
      return null;
    }

    Node<T> temp = rightNode;

    while (temp.getLeft() != null) {
      temp = temp.getLeft();
    }

    return temp;
  }
}