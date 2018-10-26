package linkedlist;

/* SOLUTION FOR TASK 2.2. Return Kth to Last */

public class Solution22 {

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addBack(1);
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        int data = (int)linkedList.findKthToLast(0);
        System.out.println(data);
    }
}
