package main.ds.linkedlist.singly;

public class FindMiddle {

    public static int getMiddle(Node head) {
        if (head == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
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
        tail.next = new Node(50);
        tail = tail.next;

        HelperLLClass obj = new HelperLLClass();

        obj.printSLL(head);
        System.out.println(getMiddle(head));
    }

}
