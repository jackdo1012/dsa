package Tree;

import java.util.Iterator;

import Queue.LinkedListBasedQueue;

public class BinarySearchTree implements BinarySearchTreeADT {
    private Node root = null;

    private int nodeCount = 0;

    @Override
    public boolean contains(int data) {
        return contains(this.root, data);
    }

    private boolean contains(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.getData()) {
            return true;
        } else if (data < root.getData()) {
            return contains(root.getLeftNode(), data);
        } else if (data > root.getData()) {
            return contains(root.getRightNode(), data);
        }
        return false;
    }

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
        if (nodeCount != 0) {
            if (contains(data)) {
                this.root = delete(this.root, data);
            }
        }
    }

    private Node delete(Node root, int data) {
        if (root != null) {
            if (data > root.getData()) {
                root.setRightNode(delete(root.getRightNode(), data));
            } else if (data < root.getData()) {
                root.setLeftNode(delete(root.getLeftNode(), data));
            } else {
                if (root.getLeftNode() == null) {
                    return root.getRightNode();
                } else if (root.getRightNode() == null) {
                    return root.getLeftNode();
                } else {
                    Node temp = root.getRightNode();
                    while (temp.getLeftNode() != null) {
                        temp = temp.getLeftNode();
                    }
                    System.out.println(temp.getData());
                    Node newNode = new Node(temp.getData());
                    newNode.setLeftNode(root.getLeftNode());
                    newNode.setRightNode(delete(root.getRightNode(), temp.getData()));
                    // System.out.println(root.getData());
                    return newNode;
                }
            }
        }
        return root;
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
        if (root == null) {
            return null;
        }
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
                LinkedListBasedQueue<Node> processQueue = new LinkedListBasedQueue<Node>();
                levelOrderTraverse(queue, processQueue);
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

    private void levelOrderTraverse(LinkedListBasedQueue<Integer> queue,
            LinkedListBasedQueue<Node> processQueue) {
        processQueue.enQueue(this.root);
        while (!processQueue.isEmpty()) {
            Node temp = processQueue.deQueue();
            queue.enQueue(temp.getData());
            if (temp.getLeftNode() != null) {
                processQueue.enQueue(temp.getLeftNode());
            }
            if (temp.getRightNode() != null) {
                processQueue.enQueue(temp.getRightNode());
            }
        }
    }
}
