package Tree;

import java.util.Iterator;

public interface BinarySearchTreeADT<T> {
    boolean contains(T data);

    T findMin();

    T findMax();

    void insert(T data);

    void delete(T data);

    T deleteMax();

    T deleteMin();

    int size();

    int height();

    Iterator<T> traverse(TraverseType type);
}
