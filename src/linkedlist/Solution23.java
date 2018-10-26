package linkedlist;

/* Solution for task 2.3 Delete middle node */
public class Solution23 {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addBack(1);
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        linkedList.deleteMiddleNode();

        linkedList.printForward();
    }
}
