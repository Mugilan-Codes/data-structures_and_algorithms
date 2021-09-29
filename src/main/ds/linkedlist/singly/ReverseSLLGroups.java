package main.ds.linkedlist.singly;

public class ReverseSLLGroups {

    public static Node reverseInGroups(Node head, int chunkSize) {
        if (head == null || head.next == null || chunkSize < 1) {
            return head;
        }

        Node previous = null;
        Node current = head;
        Node next = null;
        int count = 0;

        while (current != null && count < chunkSize) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        if (next != null) {
            // because head will be the tail node in a reversed group
            head.next = reverseInGroups(next, chunkSize);
        }

        return previous;
    }

    public static void main(String[] args) {
        Node head, tail;

        head = tail = new Node(10);

        tail.next = new Node(20);
        tail = tail.next;

        tail.next = new Node(30);
        tail = tail.next;

        tail.next = new Node(40);
        tail = tail.next;

        tail.next = new Node(50);
        tail = tail.next;

        tail.next = new Node(60);
        tail = tail.next; // no need for this

        HelperLLClass obj = new HelperLLClass();

        obj.printSLL(head);
        head = reverseInGroups(head, 4);
        obj.printSLL(head);
    }

}
