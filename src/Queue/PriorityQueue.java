package Queue;

public interface PriorityQueue<T> {
    void insert(int key, T data);

    T deleteMin();

    T deleteMax();

    T getMin();

    T getMax();

    int size();
}
