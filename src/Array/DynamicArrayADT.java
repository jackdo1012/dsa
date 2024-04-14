package Array;

public interface DynamicArrayADT<T> {
    void push(T data);

    T pop();

    void insert(T data, int index);

    boolean contains(T data);

    T removeAt(int index);

    T remove(T data);

    int indexOf(T data);

    int length();

    String toString();
}
