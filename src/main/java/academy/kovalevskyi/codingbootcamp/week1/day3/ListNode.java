package academy.kovalevskyi.codingbootcamp.week1.day3;

public class ListNode<T> {
  private ListNode<T> prev;
  private ListNode<T> next;
  private T value;

  public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
    setPrev(prev);
    setNext(next);
    this.value = value;
  }

  public void setPrev(ListNode<T> prev) {
    this.prev = prev;
    if (prev != null) {
      prev.next = this;
    }
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
    if (next != null) {
      next.prev = this;
    }
  }

  public ListNode<T> getNext() {
    return next;
  }

  public ListNode<T> getPrev() {
    return prev;
  }

  public T getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Node{"
        + "prevValue="
        + (prev == null ? null : prev.getValue())
        + ", nextValue="
        + (next == null ? null : next.getValue())
        + ", thisValue="
        + this.getValue()
        + '}';
  }
}

