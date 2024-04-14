package Tree;

public class Node<T> {
    private T data;
    private Node<T> leftNode = null;
    private Node<T> rightNode = null;

    public Node(T newData) {
        data = newData;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setData(T newData) {
        data = newData;
    }

    public void setLeftNode(Node<T> newLeftNode) {
        leftNode = newLeftNode;
    }

    public void setRightNode(Node<T> newRightNode) {
        rightNode = newRightNode;
    }
}
