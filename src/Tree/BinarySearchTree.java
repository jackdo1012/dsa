package Tree;

import java.util.Iterator;

import Queue.LinkedListBasedQueue;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {
    private Node<T> root = null;

    private int nodeCount = 0;

    @Override
    public boolean contains(T data) {
        return contains(this.root, data);
    }

    private boolean contains(Node<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (data.compareTo((T) root.getData()) == 0) {
            return true;
        } else if (data.compareTo((T) root.getData()) < 0) {
            return contains(root.getLeftNode(), data);
        } else if (data.compareTo((T) root.getData()) > 0) {
            return contains(root.getRightNode(), data);
        }
        return false;
    }

    @Override
    public T findMin() {
        if (size() == 0) {
            return null;
        }
        Node<T> current = root;
        while (current.getLeftNode() != null) {
            current = current.getLeftNode();
        }
        return current.getData();
    }

    @Override
    public T findMax() {
        if (size() == 0) {
            return null;
        }
        Node<T> current = root;
        while (current.getRightNode() != null) {
            current = current.getRightNode();
        }
        return current.getData();
    }

    @Override
    public void insert(T data) {
        insert(root, data);
    }

    private void insert(Node<T> root, T data) {
        if (size() == 0) {
            this.root = new Node<T>(data);
            nodeCount++;
        } else if (data.compareTo((T) root.getData()) < 0) {
            if (root.getLeftNode() != null) {
                insert(root.getLeftNode(), data);
            } else {
                Node<T> newNode = new Node<T>(data);
                root.setLeftNode(newNode);
                nodeCount++;
            }
        } else if (data.compareTo((T) root.getData()) > 0) {
            if (root.getRightNode() != null) {
                insert(root.getRightNode(), data);
            } else {
                Node<T> newNode = new Node<T>(data);
                root.setRightNode(newNode);
                nodeCount++;
            }
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    public void delete(T data) {
        if (nodeCount != 0) {
            if (contains(data)) {
                this.root = delete(this.root, data);
            }
        }
    }

    @Override
    public T deleteMax() {
        if (height() == 0) {
            return null;
        } else if (height() == 1) {
            T data = this.root.getData();
            this.root = null;
            return data;
        }
        Node<T> temp = this.root;
        while (temp.getRightNode().getRightNode() != null) {
            temp = temp.getRightNode();
        }
        T data = temp.getRightNode().getData();
        if (temp.getRightNode().getLeftNode() != null) {
            temp.setRightNode(temp.getRightNode().getLeftNode());
        } else {
            temp.setRightNode(null);
        }
        return data;
    }

    @Override
    public T deleteMin() {
        if (height() == 0) {
            return null;
        } else if (height() == 1) {
            T data = this.root.getData();
            this.root = null;
            return data;
        }
        Node<T> temp = this.root;
        while (temp.getLeftNode().getLeftNode() != null) {
            temp = temp.getLeftNode();
        }
        T data = temp.getLeftNode().getData();
        if (temp.getLeftNode().getRightNode() != null) {
            temp.setLeftNode(temp.getLeftNode().getRightNode());
        } else {
            temp.setLeftNode(null);
        }
        return data;
    }

    private Node<T> delete(Node<T> root, T data) {
        if (root != null) {
            if (data.compareTo((T) root.getData()) > 0) {
                root.setRightNode(delete(root.getRightNode(), data));
            } else if (data.compareTo((T) root.getData()) < 0) {
                root.setLeftNode(delete(root.getLeftNode(), data));
            } else {
                if (root.getLeftNode() == null) {
                    return root.getRightNode();
                } else if (root.getRightNode() == null) {
                    return root.getLeftNode();
                } else {
                    Node<T> temp = root.getRightNode();
                    while (temp.getLeftNode() != null) {
                        temp = temp.getLeftNode();
                    }
                    System.out.println(temp.getData());
                    Node<T> newNode = new Node<T>(temp.getData());
                    newNode.setLeftNode(root.getLeftNode());
                    newNode.setRightNode(delete(root.getRightNode(), temp.getData()));
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

    private int height(Node<T> root) {
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
    public Iterator<T> traverse(TraverseType type) {
        LinkedListBasedQueue<T> queue = new LinkedListBasedQueue<T>();
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
                LinkedListBasedQueue<Node<T>> processQueue = new LinkedListBasedQueue<Node<T>>();
                levelOrderTraverse(queue, processQueue);
                break;
            }
        }
        Iterator<T> iterator = new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                return queue.deQueue();
            }
        };
        return iterator;
    }

    private void preOrderTraverse(Node<T> root, LinkedListBasedQueue<T> queue) {
        if (root != null) {
            queue.enQueue(root.getData());
            preOrderTraverse(root.getLeftNode(), queue);
            preOrderTraverse(root.getRightNode(), queue);
        }
    }

    private void inOrderTraverse(Node<T> root, LinkedListBasedQueue<T> queue) {
        if (root != null) {
            inOrderTraverse(root.getLeftNode(), queue);
            queue.enQueue(root.getData());
            inOrderTraverse(root.getRightNode(), queue);
        }
    }

    private void postOrderTraverse(Node<T> root, LinkedListBasedQueue<T> queue) {
        if (root != null) {
            postOrderTraverse(root.getLeftNode(), queue);
            postOrderTraverse(root.getRightNode(), queue);
            queue.enQueue(root.getData());
        }
    }

    private void levelOrderTraverse(LinkedListBasedQueue<T> queue,
            LinkedListBasedQueue<Node<T>> processQueue) {
        processQueue.enQueue(this.root);
        while (!processQueue.isEmpty()) {
            Node<T> temp = processQueue.deQueue();
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
