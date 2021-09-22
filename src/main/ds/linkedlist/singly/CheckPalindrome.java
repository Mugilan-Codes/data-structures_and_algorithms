package main.ds.linkedlist.singly;

public class CheckPalindrome {
    private static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node previousNode = null;
        Node nextNode;
        Node current = head;

        while(current != null) {
            nextNode = current.next;
            current.next = previousNode;
            previousNode = current;
            current = nextNode;
        }

        return previousNode;
    }

    private static Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null) {
            return true;
        }
        Node middle = getMiddle(head);
        Node secondHalf = reverseList(middle);

        Node current = head;
        while (secondHalf != null) {
            if (current.data != secondHalf.data) {
                return false;
            }
            current = current.next;
            secondHalf = secondHalf.next;
        }

        return true;
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
        tail.next = new Node(20);
        tail = tail.next;
        tail.next = new Node(10);
        tail = tail.next;

        HelperLLClass obj = new HelperLLClass();

        obj.printSLL(head);
        System.out.println(isPalindrome(head));
    }
}
