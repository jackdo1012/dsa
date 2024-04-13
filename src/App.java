import LinkedList.SinglyLinkedList;
import Queue.LinkedListBasedQueue;
import Stack.LinkedListBasedStack;

public class App {
    public static void main(String[] args) throws Exception {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.insert("3rd value", 0);
        list.insert("2nd value", 1);
        list.insert("1st value", 0);
        list.insert("last", -1);
        list.delete(0);
        // list.deleteList();
        System.out.println(list.count());
        System.out.println(list.toString());
        System.out.println(list.getAt(1));

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
    }
}
