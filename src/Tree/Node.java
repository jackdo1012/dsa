package Tree;

public class Node {
    private int data;
    private Node leftNode = null;
    private Node rightNode = null;

    public Node(int newData) {
        data = newData;
    }

    public int getData() {
        return data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setData(int newData) {
        data = newData;
    }

    public void setLeftNode(Node newLeftNode) {
        leftNode = newLeftNode;
    }

    public void setRightNode(Node newRightNode) {
        rightNode = newRightNode;
    }
}
