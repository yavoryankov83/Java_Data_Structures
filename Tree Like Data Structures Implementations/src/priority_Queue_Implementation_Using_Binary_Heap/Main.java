package priority_Queue_Implementation_Using_Binary_Heap;

public class Main {

  public static void main(String[] args) {
    MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueueImpl<>();

    priorityQueue.push(5);
    priorityQueue.push(8);
    priorityQueue.push(1);
    priorityQueue.push(3);
    priorityQueue.push(12);
    priorityQueue.push(-4);

    while (priorityQueue.size() > 0) {
      System.out.println(priorityQueue.pop());
    }
  }
}
