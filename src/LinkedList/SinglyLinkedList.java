package LinkedList;

public class SinglyLinkedList<T> implements LinkedListADT<T> {
    Node<T> head = null;

    private int size = 0;

    public SinglyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /**
     * Insert data to linked list
     * 
     * @param value Value to insert
     * @param index Index to insert, -1 to insert at the end
     */
    public void insert(T value, int index) {
        Node<T> currentNode = head;
        if (index == -1) {
            index = size;
        } else if (index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (isEmpty()) {
            head = new Node<T>(value, null);
        } else if (index == 0) {
            head = new Node<T>(value, head);
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            if (currentNode.getNext() != null) {
                Node<T> newNode = new Node<T>(value, currentNode.getNext());
                currentNode.setNext(newNode);
            } else {
                Node<T> newNode = new Node<T>(value, null);
                currentNode.setNext(newNode);
            }
        }
        size++;
    }

    @Override
    public void delete(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else if (isEmpty()) {
            throw new IllegalArgumentException("Linked list is empty");
        } else if (index == 0) {
            deleteHead();
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> newNextNode = currentNode.getNext().getNext();
            currentNode.getNext().setData(null);
            currentNode.getNext().setNext(null);
            if (newNextNode == null) {
                currentNode.setNext(null);
            } else {
                currentNode.setNext(newNextNode);
            }
        }
        size--;
    }

    @Override
    public void deleteList() {
        if (!isEmpty()) {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                Node<T> prevNode = currentNode;
                currentNode = currentNode.getNext();
                prevNode.setData(null);
                prevNode.setNext(null);
            }
        }
        size = 0;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public T getAt(int index) {
        if (index >= size) {
            return null;
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String result = "";
        Node<T> currentNode = head;
        result += currentNode.getData().toString();
        while (currentNode.getNext() != null) {
            result += ", ";
            result += currentNode.getNext().getData().toString();
            currentNode = currentNode.getNext();
        }
        return result;
    }

    @Override
    public void deleteTail() {
        delete(size - 1);
    }

    @Override
    public void deleteHead() {
        if (size <= 1) {
            head = null;
        } else {
            Node<T> currentNode = head;
            head = head.getNext();
            currentNode.setData(null);
            currentNode.setNext(null);
        }
    }
}
