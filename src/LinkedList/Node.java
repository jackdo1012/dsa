package LinkedList;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T value, Node<T> nextNode) {
        data = value;
        next = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T value) {
        data = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextNode) {
        next = nextNode;
    }
}
