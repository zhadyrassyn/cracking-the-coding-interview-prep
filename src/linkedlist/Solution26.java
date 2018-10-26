package linkedlist;

/* Solution for 2.6 task. Palindrome */
public class Solution26 {


    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addBack(3);
//        linkedList.addBack(3);
//        linkedList.addBack(3);
//        linkedList.addBack(3);

        linkedList.printForward();
        System.out.println(linkedList.isPalindrome());

    }
}
