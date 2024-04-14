import java.util.Iterator;

import LinkedList.SinglyLinkedList;
import Queue.LinkedListBasedQueue;
import Stack.LinkedListBasedStack;
import Tree.BinarySearchTree;
import Tree.TraverseType;

public class App {
    public static void main(String[] args) throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.insert("3rd value", 0);
        list.insert("2nd value", 1);
        list.insert("1st value", 0);
        list.insert("last", -1);
        list.delete(0);
        System.out.println(list.count());
        System.out.println(list.toString());
        System.out.println(list.getAt(1));
        list.deleteList();
        System.out.println(list.toString());

        LinkedListBasedStack<String> stack = new LinkedListBasedStack<String>();
        stack.push("value1");
        stack.push("value2");
        System.out.println(stack.pop());
        System.out.println(stack.size());

        LinkedListBasedQueue<String> queue = new LinkedListBasedQueue<String>();
        queue.enQueue("value1");
        queue.enQueue("value2");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(10);
        Iterator<Integer> binarySearchTreeTraverse = binarySearchTree.traverse(TraverseType.INORDER);
        while (binarySearchTreeTraverse.hasNext()) {
            System.out.print(binarySearchTreeTraverse.next());
        }
        System.out.println("");
        System.out.println(binarySearchTree.height());
        System.out.println(binarySearchTree.findMax());
        System.out.println(binarySearchTree.findMin());
    }
}
