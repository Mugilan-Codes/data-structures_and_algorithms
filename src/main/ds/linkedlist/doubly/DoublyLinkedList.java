package main.ds.linkedlist.doubly;

public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        head = null;
    }

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
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
