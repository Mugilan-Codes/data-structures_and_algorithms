package main.ds.linkedlist;

// Reverse Singly Linked List
public class ReverseSLL {

    public static Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node previousNode = null;
        Node nextNode = null;
        Node current = head;

        while(current != null) {
            // System.out.println("-> current before = " + current);

            nextNode = current.next;
            // System.out.println("nextNode = " + nextNode);

            current.next = previousNode;
            // System.out.println("current.next = " + current.next);

            previousNode = current;
            // System.out.println("previousNode = " + previousNode);

            current = nextNode;
            // System.out.println("-> current after = " + current);
        }

        return previousNode;

    }

    public static void main(String[] args) {

        Node head;
        Node tail;

        head = tail = new Node(10);

        tail.next = new Node(20);
        tail = tail.next;

        tail.next = new Node(30);
        tail = tail.next;

        tail.next = new Node(40);
        tail = tail.next;

        tail.next = new Node(50);
        tail = tail.next; // no need for this

        HelperLLClass obj = new HelperLLClass();

        obj.printSLL(head);
        head = reverse(head); // get updated head
        obj.printSLL(head);


    }

}
