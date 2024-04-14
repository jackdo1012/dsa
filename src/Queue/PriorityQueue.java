package Queue;

import Tree.BinarySearchTree;

public class PriorityQueue<T> implements PriorityQueueADT<T> {
    private BinarySearchTree<PriorityQueueNode<T>> tree = null;

    public PriorityQueue() {
        tree = new BinarySearchTree<PriorityQueueNode<T>>();
    }

    @Override
    public void insert(int key, T data) {
        PriorityQueueNode<T> node = new PriorityQueueNode<T>(key, data);
        tree.insert(node);
    }

    @Override
    public T deleteMin() {
        if (isEmpty()) {
            return null;
        }
        return tree.deleteMin().getValue();
    }

    @Override
    public T deleteMax() {
        if (isEmpty()) {
            return null;
        }
        return tree.deleteMax().getValue();
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return tree.findMin().getValue();
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return tree.findMax().getValue();
    }

    @Override
    public int size() {
        return tree.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
