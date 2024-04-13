package LinkedList;

public interface LinkedListADT<T> {
    boolean isEmpty();

    void insert(T value, int index);

    void delete(int index);

    void deleteTail();

    void deleteHead();

    void deleteList();

    int count();

    T getAt(int index);

    String toString();
}
