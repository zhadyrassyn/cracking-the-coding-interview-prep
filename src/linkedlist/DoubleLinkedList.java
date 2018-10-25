package linkedlist;

public class DoubleLinkedList {
    public Node head;
    public Node tail;

    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + ", " );
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }


        Node temp = head;
        while(temp != null) {
            int data = temp.data;
            Node prev = temp.prev;

            while (prev != null && prev.data != data) {
                prev = prev.prev;
            }

            if (prev != null) {
                if (temp.next == null) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
    }

    public int findKthToLast(int k) {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = tail;
        while (k-- > 0) {
            temp = temp.prev;
            if (temp == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        return temp.data;
    }

    public void deleteMiddleNode() {
        if (head == null || head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        Node temp2 = head.next;

        while (temp2 != null && temp2 != tail) {
            temp2 = temp2.next;
            if (temp2 != tail) {
                temp2 = temp2.next;
            }
            temp = temp.next;
        }


        Node prev = temp.prev;
        if (prev == null) {
            head = tail;
        } else {
            prev.next = temp.next;
            temp.next.prev = prev;
        }
    }

    static class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int nodeData) {
            this.data = nodeData;
        }
    }
}
