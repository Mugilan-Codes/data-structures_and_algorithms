package main.ds.linkedlist.doubly;

public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();

        System.out.println(dl.isEmpty());

        System.out.println(dl.size());
        dl.push(20);
        dl.push(30);
        dl.push(10);
        System.out.println(dl.size());

        System.out.println(dl);
        dl.append(40);
        System.out.println(dl);

        dl.display();

        dl.search(10);
        dl.search(25);

        dl.removeFirst();
        System.out.println(dl);

        dl.removeLast();
        System.out.println(dl);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // add at the beginning (prepend)
    public void push(int data) {
        Node newNode = new Node(data);

        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    // add at the end (append)
    public void append(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = null; // since this is going to be the last node

        // traverse from head to the last node in the list
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;
        head.prev = null;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    private boolean isPresent(int key) {
        if (isEmpty()) {
            return false;
        }

        Node current = head;

        while (current != null) {
            if (current.data == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void search(int key) {
        if (isPresent(key)) {
            System.out.println("Key " + key + " is found");
        } else {
            System.out.println("Key " + key + " is not found");
        }
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder();

        while (current != null) {
            if (current == head) {
                sb.append("[Head: ").append(current.data).append("]");
                if (current.next != null) {
                    sb.append(" <-");
                }
            } else if (current.next == null) {
                sb.append("-> [Tail: ").append(current.data).append("]");
            } else {
                sb.append("-> [").append(current.data).append("] <-");
            }

            current = current.next;
        }

        return sb.toString();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Doubly Linked List is Empty");
            return;
        }

        System.out.println(this);
    }

    // contains data, and references to previous node and next node
    private static class Node {
        int data;
        Node prev = null;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder printStr = new StringBuilder();

            printStr.append("<Node data=").append(data);

            if (prev != null) {
                printStr.append(" prev=").append(prev.data);
            }
            if (next != null) {
                printStr.append(" next=").append(next.data);
            }

            printStr.append(">");

            return printStr.toString();
        }
    }
}
