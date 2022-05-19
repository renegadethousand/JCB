package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper {

  public static void main(String[] args) {
    ListNode<String> node1 = new ListNode<>(null, null, "1 node");
    ListNode<String> node2 = new ListNode<>(null, null, "2 node");
    ListNode<String> node3 = new ListNode<>(null, null, "3 node");
    ListNode<String> node4 = new ListNode<>(null, null, "4 node");
    node1.setPrev(node2);
    node2.setPrev(node3);
    node3.setPrev(node4);
    System.out.println(length(node3));
  }

  public static <T> int length(ListNode<T> someNode) {
    int nodeCount = 1;
    ListNode<T> nextNode = someNode.getNext();
    while (nextNode != null) {
      nodeCount++;
      nextNode = nextNode.getNext();
    }
    ListNode<T> prevNode = someNode.getPrev();
    while (prevNode != null) {
      nodeCount++;
      prevNode = prevNode.getPrev();
    }
    return nodeCount;
  }

  public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
    while (someNode.getNext() != null) {
      someNode = someNode.getNext();
    }
    return new ListNode<>(someNode, null, newValue);
  }

  public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
    while (someNode.getPrev() != null) {
      someNode = someNode.getPrev();
    }
    return new ListNode<>(null, someNode, newValue);
  }

  public static <T> boolean contains(ListNode<T> someNode, T value) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    if (someNode.getValue() == value) {
      return true;
    }
    ListNode<T> nextNode = someNode.getNext();
    while (nextNode != null) {
      if (nextNode.getValue() == value) {
        return true;
      }
      nextNode = nextNode.getNext();
    }
    ListNode<T> prevNode = someNode.getPrev();
    while (prevNode != null) {
      if (prevNode.getValue() == value) {
        return true;
      }
      prevNode = prevNode.getPrev();
    }
    return false;
  }

  public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
    while (true) {
      if (someNode.getPrev() == null) {
        break;
      }
      someNode = someNode.getPrev();
    }
    ListNode<R> currentNode = new ListNode<>(null, null, mapFunction.apply(someNode.getValue()));
    while (someNode.getNext() != null) {
      someNode = someNode.getNext();
      R newValue = mapFunction.apply(someNode.getValue());
      currentNode = insertAfter(currentNode, newValue);
    }
    return currentNode;
  }

  public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
    return new ListNode<>(prev, prev.getNext(), newValue);
  }

  public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
    for (int i = 0; i < newValues.length; i++) {
      prev = insertAfter(prev, newValues[i]);
    }
  }

  public static <T> T delete(ListNode<T> current) {
    ListNode<T> prevNode = current.getPrev();
    ListNode<T> nextNode = current.getNext();
    if (prevNode != null) {
      prevNode.setNext(nextNode);
    }
    if (nextNode != null) {
      nextNode.setPrev(prevNode);
    }
    current.setPrev(null);
    current.setNext(null);
    return current.getValue();
  }
}

