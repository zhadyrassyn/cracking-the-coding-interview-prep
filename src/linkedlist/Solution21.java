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
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(4);
        linkedList.addLast(4);
        linkedList.addLast(4);
        linkedList.addLast(4);

        linkedList.print();

        linkedList.removeDuplicates();

        linkedList.print();

    }
}