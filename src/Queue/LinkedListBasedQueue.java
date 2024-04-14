package Queue;

import LinkedList.SinglyLinkedList;

public class LinkedListBasedQueue<T> implements QueueADT<T> {
    private SinglyLinkedList<T> linkedList = null;

    public LinkedListBasedQueue() {
        linkedList = new SinglyLinkedList<T>();
    }

    @Override
    public void enQueue(T value) {
        linkedList.insert(value, -1);
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = linkedList.getAt(0);
        linkedList.deleteHead();
        return data;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return linkedList.getAt(0);
    }

    @Override
    public T rear() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return linkedList.getAt(-1);
    }

    @Override
    public int size() {
        return linkedList.count();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
