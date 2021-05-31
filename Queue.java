// SARMIENTO, Michael Joshua P.
// ICS 2605 1CSA
// Lab Exercise 07
//
//

public class Queue<T> {
    private int front = -1, rear = -1, maxQueueSize = 100;
    private Object[] que;

    public Queue(int n){
        if (n > 0) maxQueueSize = n;
        que = new Object[maxQueueSize];
    }

    public Queue(){
        que = new Object[maxQueueSize];
    }

    public boolean isFull(){
        return (rear+1)%maxQueueSize == front;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public void clear(){
        front = rear = -1;
    }

    public int enqueue(T el){
        if(isFull()) return -999;
        if(isEmpty()) {
            front = 0;
            rear = 0;
        } else rear = (rear+1)%maxQueueSize;
        que[rear] = el;
        return 1;
    }

    public T dequeue(){
        if(isEmpty()) return null;
        T el = (T) que[front];
        if (front == rear) clear(); // if one element
        else front = (front+1)%maxQueueSize;
        return el;
    }

    public T peek(){
        if(isEmpty()) return null;
        return (T) que[front];
    }
}
