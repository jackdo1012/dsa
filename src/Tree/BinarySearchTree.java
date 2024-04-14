package Tree;

import java.util.Iterator;

import Queue.LinkedListBasedQueue;

public class BinarySearchTree implements BinarySearchTreeADT {
    private Node root = null;

    private int nodeCount = 0;

    @Override
    public int findMin() {
        Node current = root;
        while (current.getLeftNode() != null) {
            current = current.getLeftNode();
        }
        return current.getData();
    }

    @Override
    public int findMax() {
        Node current = root;
        while (current.getRightNode() != null) {
            current = current.getRightNode();
        }
        return current.getData();
    }

    @Override
    public void insert(int data) {
        insert(root, data);
    }

    private void insert(Node root, int data) {
        if (size() == 0) {
            this.root = new Node(data);
            nodeCount++;
        } else if (data < root.getData()) {
            if (root.getLeftNode() != null) {
                insert(root.getLeftNode(), data);
            } else {
                Node newNode = new Node(data);
                root.setLeftNode(newNode);
                nodeCount++;
            }
        } else if (data > root.getData()) {
            if (root.getRightNode() != null) {
                insert(root.getRightNode(), data);
            } else {
                Node newNode = new Node(data);
                root.setRightNode(newNode);
                nodeCount++;
            }
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    public void delete(int data) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodeHeight = height(root.getLeftNode()) + 1;
        int rightNodeHeight = height(root.getRightNode()) + 1;
        if (leftNodeHeight > rightNodeHeight) {
            return leftNodeHeight;
        } else {
            return rightNodeHeight;
        }
    }

    @Override
    public Iterator<Integer> traverse(TraverseType type) {
        LinkedListBasedQueue<Integer> queue = new LinkedListBasedQueue<Integer>();
        switch (type) {
            case INORDER: {
                inOrderTraverse(this.root, queue);
                break;
            }
            case POSTORDER: {
                postOrderTraverse(this.root, queue);
                break;
            }
            case PREORDER: {
                preOrderTraverse(this.root, queue);
                break;
            }
            case LEVELORDER: {
                break;
            }
        }
        Iterator<Integer> iterator = new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Integer next() {
                return queue.deQueue();
            }
        };
        return iterator;
    }

    private void preOrderTraverse(Node root, LinkedListBasedQueue<Integer> queue) {
        if (root != null) {
            queue.enQueue(root.getData());
            preOrderTraverse(root.getLeftNode(), queue);
            preOrderTraverse(root.getRightNode(), queue);
        }
    }

    private void inOrderTraverse(Node root, LinkedListBasedQueue<Integer> queue) {
        if (root != null) {
            inOrderTraverse(root.getLeftNode(), queue);
            queue.enQueue(root.getData());
            inOrderTraverse(root.getRightNode(), queue);
        }
    }

    private void postOrderTraverse(Node root, LinkedListBasedQueue<Integer> queue) {
        if (root != null) {
            postOrderTraverse(root.getLeftNode(), queue);
            postOrderTraverse(root.getRightNode(), queue);
            queue.enQueue(root.getData());
        }
    }
}
