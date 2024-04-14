import java.util.Iterator;

import Array.DynamicArray;
import LinkedList.SinglyLinkedList;
import Queue.LinkedListBasedQueue;
import Queue.PriorityQueue;
import Stack.LinkedListBasedStack;
import Tree.BinarySearchTree;
import Tree.TraverseType;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicArray<String> array = new DynamicArray<String>(5);
        array.push("1data");
        array.push("3data");
        array.push("4data");
        array.insert("2data", 1);
        array.remove("3data");
        array.removeAt(0);
        System.out.println(array.toString());

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

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(10);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(14);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(13);
        /*  8
           / \
          3   10
         / \    \
        1   6    14
           / \   /
          4   7 13
        */
        binarySearchTree.delete(3);
        binarySearchTree.deleteMax();
        Iterator<Integer> binarySearchTreeTraverse = binarySearchTree.traverse(TraverseType.LEVELORDER);
        if (binarySearchTreeTraverse != null) {
            while (binarySearchTreeTraverse.hasNext()) {
                System.out.print(binarySearchTreeTraverse.next() + " ");
            }
        }
        System.out.println("");
        System.out.println(binarySearchTree.height());
        System.out.println(binarySearchTree.findMax());
        System.out.println(binarySearchTree.findMin());
        System.out.println(binarySearchTree.contains(11));
        System.out.println(binarySearchTree.contains(10));

        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.insert(100000, "this one is important");
        priorityQueue.insert(200000, "this one is very important");
        priorityQueue.insert(1, "this one is not important");
        System.out.println(priorityQueue.deleteMax());
        System.out.println(priorityQueue.deleteMin());
        System.out.println(priorityQueue.getMax());
        System.out.println(priorityQueue.getMin());
    }
}
