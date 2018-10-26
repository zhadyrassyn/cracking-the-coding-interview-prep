package linkedlist;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Solution for task 2.1. Remove dups */
public class Solution21 {


    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addBack(1);
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);
        linkedList.addBack(4);
        linkedList.addBack(4);
        linkedList.addBack(4);
        linkedList.addBack(4);
        linkedList.addBack(4);

        linkedList.printForward();

        linkedList.removeDuplicates();

        linkedList.printForward();

    }
}