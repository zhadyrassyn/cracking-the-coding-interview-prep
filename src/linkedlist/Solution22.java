package linkedlist;

/* SOLUTION FOR TASK 2.2. Return Kth to Last */

public class Solution22 {

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        int data = linkedList.findKthToLast(0);
        System.out.println(data);
    }
}
