package linkedlist;

import java.util.AbstractList;
import java.util.Objects;

public class DoubleLinkedList<E> extends AbstractList<E> {
    public Node<E> head;
    public Node<E> tail;
    int size;

    public E remove(int index) throws IndexOutOfBoundsException{
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = this.head;
        while(index != 0) {
            temp = temp.next;
            --index;
        }
        Node<E> pre = temp.prev;
        Node<E> nex = temp.next;
        if(pre == null && nex == null) {
            this.head = null;
            this.tail = null;
            --size;
        } else if(pre == null) {
            removeFirst();
        } else if(nex == null) {
            removeLast();
        } else {
            pre.next = nex;
            nex.prev = pre;
            --size;
        }
        return temp.data;
    }

    public E removeFirst() throws IndexOutOfBoundsException{
        if(size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = this.head;
        this.head = temp.next;
        this.head.prev = null;
        E data = temp.data;
        temp = null;

        --size;
        return data;
    }

    public E removeLast() throws IndexOutOfBoundsException{
        if(size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = this.tail;
        this.tail = temp.prev;
        this.tail.next = null;
        E data = temp.data;
        temp = null;

        --size;
        return data;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = this.head;
        while(index != 0) {
            temp = temp.next;
            --index;
        }
        return temp.data;
    }

    public E set(int index, E data) throws IndexOutOfBoundsException, NullPointerException {
        if(data == null) {
            throw new NullPointerException();
        }
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = this.head;
        while(index != 0) {
            temp = temp.next;
            --index;
        }
        temp.data = data;
        return temp.data;
    }

    public boolean addFront(E data) {
        Node<E> newNode = new Node<E>(data);
        if(head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        ++size;
        return true;
    }

    public boolean addBack(E data) {
        Node<E> newNode = new Node<E>(data);
        if(tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        ++size;
        return true;
    }

    public void addAtIndex(int index, E data) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            addFront(data);
        } else {
            Node<E> newNode = new Node<E>(data);
            Node<E> temp = this.head;
            while(index != 0) {
                temp = temp.next;
                --index;
            }
            Node<E> prev = temp.prev;

            temp.prev = newNode;
            newNode.next = temp;
            prev.next = newNode;
            newNode.prev = prev;
            ++size;
        }
    }

    public int size() {
        return this.size;
    }

    public void printForward() {
        Node<E> temp = this.head;
        while(temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public void printBackword() {
        Node<E> temp = this.tail;
        while(temp != null) {
            System.out.print(temp);
            temp = temp.prev;
        }
        System.out.println();
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }


        Node<E> temp = head;
        while(temp != null) {
            E data = temp.data;
            Node<E> prev = temp.prev;

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

    public E findKthToLast(int k) {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = tail;
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

        Node<E> temp = head;
        Node<E> temp2 = head.next;

        while (temp2 != null && temp2 != tail) {
            temp2 = temp2.next;
            if (temp2 != tail) {
                temp2 = temp2.next;
            }
            temp = temp.next;
        }


        Node<E> prev = temp.prev;
        if (prev == null) {
            head = tail;
        } else {
            prev.next = temp.next;
            temp.next.prev = prev;
        }
    }

    public boolean isPalindrome() {
        if (head == null || head == tail) {
            return true;
        }

        Node<E> tempFront = head;
        Node<E> tempLast = tail;

        boolean isPalindrome = true;
        while (isPalindrome) {
            if (!Objects.equals(tempFront.data, tempLast.data)) {
                isPalindrome = false;
            }

            if (tempFront == tempLast || tempFront.next == tempLast) {
                break;
            }

            tempFront = tempFront.next;
            tempLast = tempLast.prev;
        }

        return isPalindrome;
    }

    static class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(E nodeData) {
            this.data = nodeData;
        }
    }
}
