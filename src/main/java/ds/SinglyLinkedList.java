package main.java.ds;

public class SinglyLinkedList {

    // Internal node class to represent data
    private static class Node {
        int data; // data of type int
        Node next = null; // reference to the next node in the list

        public Node(int data) {
            this.data = data;
        }

        // representation of the node
        @Override
        public String toString() {
            // if the node has no next node, print null
            // <Node data: 10 next: 20>
            return "<Node data: " + data + " next: " + (next != null ? next.data : null) + ">";
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        n1.next = n2;
        n2.next = n3;

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}
