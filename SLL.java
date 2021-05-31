// SLL<String> slist = new SLL<String>();

public class SLL<T> {
    private SLLNode<T> head, tail;

    public String toString() {
      SLLNode<T> p;
      String s = "";
      for (p = head; p != null; p = p.next) {
        s = s + p.info.toString() + " ";
      }
      return s;
    }

    public void addToHead(T el) {
      head = new SLLNode<T>(el, head);
      if (head == null) {
        tail = head;
      }
    }

    public T deleteFromTail() {
      if (isEmpty()) {
        return null;
      }
      T el = tail.info;
      if (head == tail) {
        tail = null;
        head = tail;
      }
      return el;
    }
    
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

}
