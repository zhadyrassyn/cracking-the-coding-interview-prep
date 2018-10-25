package linkedlist;

/* Solution for task 2.3 Delete middle node */
public class Solution23 {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.deleteMiddleNode();

        linkedList.print();
    }
}
