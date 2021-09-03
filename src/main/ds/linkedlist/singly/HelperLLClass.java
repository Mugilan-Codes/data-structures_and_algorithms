package main.ds.linkedlist.singly;

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "<Node data : " + data + ">";
    }
}

public class HelperLLClass {

    public void printSLL(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

}
