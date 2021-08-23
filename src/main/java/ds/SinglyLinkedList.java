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
            // final Integer integer = next != null ? next.data : null;
            // <Node data: 10 next: 20>
            return "<Node data: " + data + " next: " + (next != null ? next.data : null) + ">";
            // <Node data: 10>
            // return "<Node data: " + data + ">";
        }
    }

    private Node head; // Denotes the Head of the linked list
    private int sizeOfList = 0; // Track the size of the list for O(1) operations

    // constructor
    public SinglyLinkedList() {
        head = null;
    }

    // Method to display the size of Linked List.
    // Takes O(1) or Constant Time.
    public int size() {
        return sizeOfList;
    }

    // Method to check whether the Linked List is empty or not.
    // Takes O(1) or Constant Time.
    public boolean isEmpty() {
        return sizeOfList == 0;
    }
}

class TestSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList l = new SinglyLinkedList();

        System.out.println(l.size());
        System.out.println(l.isEmpty());

    }

}
