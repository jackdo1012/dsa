package Queue;

public class PriorityQueueNode<T> implements Comparable<PriorityQueueNode<T>> {
    private int key;
    private T value;

    public PriorityQueueNode(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int compareTo(PriorityQueueNode<T> o) {
        return this.getKey() - o.getKey();
    }
}
