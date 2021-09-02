package main.ds.linkedlist.doubly;

public class ReverseDLL {

    private static void swap(Node node) {
        Node temp = node.prev;
        node.prev = node.next;
        node.next = temp;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            swap(current); // swap prev and next nodes

            prev = current; // store the current node as previous to use it later
            current = current.prev; // move forward. since prev and next were swapped
        }

        if (prev != null) {
            head = prev; // set head to last node
        }

        return head;
    }

    public static void main(String[] args) {
        Node head;
        Node prevNode = null;
        Node tail;

        head = tail = new Node(10);
        tail.prev = prevNode;

        tail.next = new Node(20);
        prevNode = tail;
        tail = tail.next;
        tail.prev = prevNode;

        tail.next = new Node(30);
        prevNode = tail;
        tail = tail.next;
        tail.prev = prevNode;

        tail.next = new Node(40);
        prevNode = tail;
        tail = tail.next;
        tail.prev = prevNode;

        HelperClass obj = new HelperClass();

        obj.print(head);
        head = reverse(head);
        obj.print(head);
    }

}
