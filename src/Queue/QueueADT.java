package Queue;

public interface QueueADT<T> {
    void enQueue(T value);

    T deQueue();

    T front();

    T rear();

    int size();

    boolean isEmpty();
}
