package Tree;

import java.util.Iterator;

public interface BinarySearchTreeADT {
    int findMin();

    int findMax();

    void insert(int data);

    void delete(int data);

    int size();

    int height();

    Iterator<Integer> traverse(TraverseType type);
}
