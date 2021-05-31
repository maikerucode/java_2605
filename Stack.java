// SARMIENTO, Michael Joshua P.
// ICS 2605 1CSA
// Lab Exercise 05
//
//
public class Stack<T> {
  private int maxStkSize = 100;
  private int top = -1;
  private Object[] stk;

  public Stack() {
    stk = new Object[maxStkSize];
  }

  public Stack(int n) {
    if (n > 0) {
      maxStkSize = n;
      stk = new Object[maxStkSize];
    }
  }

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    return false;
  }

  public boolean isFull() {
    if (top > maxStkSize) {
      return true;
    }
    return false;
  }

  public int push(T el) {
    if (isFull()) {
      return -999;
    }
    else {
      stk[++top] = el;
      return 1;
    }
  }

  public T pop() {
    if (isEmpty()) {
      return null;
    }
    T el = (T) stk[top--];
    return el;
  }

  public T peek() {
    if (isEmpty()) {
      return null;
    }
    T el = (T) stk[top];
    return el;
  }

}
