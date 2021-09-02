package main.ds.linkedlist.doubly;

class Node {
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

public class HelperClass {
    public void print(Node head) {
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

        System.out.println(sb);
    }
}
