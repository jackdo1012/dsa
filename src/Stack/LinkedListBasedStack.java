package Stack;

import LinkedList.SinglyLinkedList;

public class LinkedListBasedStack<T> implements StackADT<T> {
    private int size = 0;
    private SinglyLinkedList<T> stack = null;

    public LinkedListBasedStack() {
        stack = new SinglyLinkedList<T>();
    }

    @Override
    public void push(T data) {
        stack.insert(data, 0);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = stack.getAt(0);
        stack.deleteHead();
        size--;
        return data;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        T data = stack.getAt(0);
        return data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
