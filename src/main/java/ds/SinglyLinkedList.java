package main.java.ds;

// TODO: use try catch blocks to throw exceptions
public class SinglyLinkedList {
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

    // Adds new node containing data at the `head` of the list.
    // Takes O(1) time or Constant Time
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        sizeOfList++;
    }

    // Add new node containing data at the `tail` of the list
    // Takes O(n) time or Linear Time
    public void addLast(int data) {
        // add to head if the list is empty
        if (isEmpty()) {
            add(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        // loop until the tail node is reached
        while (current.next != null) {
            current = current.next;
        }

        // assign tail node to be the new node
        current.next = newNode;
        sizeOfList++;
    }

    // Returns the index position of the given key
    // helper function
    // Takes O(n) time or Linear Time
    private int findIndex(int key) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == key) {
                return position;
            }

            current = current.next;
            position++;
        }

        return -1;
    }

    // Searches for the given key in the list.
    // uses findIndex()
    public void search(int key) {
        int index = findIndex(key);
        if (index == -1) {
            System.out.println("Key " + key + " not found");
        } else {
            System.out.println("Key " + key + " found at Index: " + index);
        }
    }

    // Returns the `Node` at specified index
    // helper function
    // Takes O(n) time or Linear Time
    private Node findNodeAtIndex(int index) {
        // safety check
        if (index < 0 || index >= sizeOfList) {
            return null;
        }

        if (index == 0) {
            return head;
        }

        Node current = head;
        int position = 0;

        while (position < index) {
            current = current.next;
            position++;
        }

        return current;
    }

    // Find and Display the `Node` at specified index
    // uses findNodeAtIndex()
    public void nodeAtIndex(int index) {
        // positive index check (or) index out of range check
        if (index < 0 || index >= sizeOfList) {
            System.out.println("Index must be positive and within the range of the list");
        } else {
            Node findNode = findNodeAtIndex(index);
            System.out.println("The Node at index " + index + " is " + findNode);
        }
    }

    // Inserts a new `Node` containing data at any index position
    // uses add() or addLast() based on index
    // Takes O(n) time or Linear Time
    public void insert(int data, int index) {
        if (index > sizeOfList || index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            add(data);
            return;
        }
        if (index == sizeOfList) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);

        Node current = head;
        int position = index;

        // loop to find (index - 1)th `Node`
        while (position > 1) {
            current = current.next;
            position--;
        }

        // assign previous and next nodes
        Node prevNode = current;
        Node nextNode = current.next;

        // assign new node in between the previous and next nodes
        prevNode.next = newNode;
        newNode.next = nextNode;

        sizeOfList++;
    }

    // Removes `Node` at the head of the list
    // Takes O(1) time or Constant Time
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        sizeOfList--;
        head = head.next;
    }

    // Removes `Node` at the tail of the list
    // Takes O(n) time or Linear Time
    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        Node current = head;

        // loop until the next node is the tail node
        while (current.next.next != null) {
            current = current.next;
        }

        sizeOfList--;
        current.next = null;
    }

    // Removes the first occurrence of the given.
    // Returns the removed `Node` if found, null otherwise
    // Takes O(n) time or Linear Time
    public Node remove(int key) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == key) {
                if (current == head) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

                sizeOfList--;
                return current;
            }

            prev = current;
            current = current.next;
        }

        return null;
    }

    // Removes `Node` from specified index
    // Returns the removed `Node` if found. returns null if the removed node is head or tail or if the index is out of range or list is empty.
    // Takes O(n) time or Linear Time
    public Node removeAtIndex(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index >= sizeOfList || index < 0) {
            return null;
        }

        if (index == 0) {
            removeFirst();
            return null;
        }
        if (index == (sizeOfList - 1)) {
            removeLast();
            return null;
        }

        Node current = head;
        int position = index;

        while (position > 1) {
            current = current.next;
            position--;
        }

        Node prev = current;
        current = current.next; // `Node` to be removed

        prev.next = current.next;
        sizeOfList--;

        return current;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder printStr = new StringBuilder();

        while (current != null) {
            if (current == head) {
                printStr.append("[Head: ").append(current.data).append("]-> ");
            } else if (current.next == null) {
                printStr.append("[Tail: ").append(current.data).append("]");
            } else {
                printStr.append("[").append(current.data).append("]-> ");
            }
            current = current.next;
        }

        return printStr.toString();
    }

    // Representation of the Linked List. (toString() alternative)
    // uses toString() override internally
    // Takes O(n) time or Linear Time
    public void display() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }

        System.out.println(this); // this calls @override toString() method
    }

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
}

class TestSinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList l = new SinglyLinkedList();

        System.out.println(l.size());
        System.out.println(l.isEmpty());
        l.display();

        l.addLast(10);
        l.display();

        l.add(1);
        l.add(2);

        System.out.println(l.size());
        System.out.println(l.isEmpty());

        System.out.println(l);
        l.display();

        l.addLast(5);
        l.display();

        l.search(11);
        l.search(10);

        l.nodeAtIndex(-1);
        l.nodeAtIndex(0);
        l.nodeAtIndex(3);
        l.nodeAtIndex(4);

        l.insert(4, -1);
        l.insert(30, 0);
        l.display();
        l.insert(75, l.size());
        l.display();

        System.out.println(l.size());
        l.insert(40, 6);
        l.insert(50, 9);
        l.display();
        System.out.println(l.size());

        l.removeFirst();
        l.display();

        l.removeLast();
        l.display();

        System.out.println(l.remove(10));
        l.display();
        System.out.println(l.size());
        System.out.println(l.remove(75));
        l.display();
        System.out.println(l.size());

        System.out.println(l.removeAtIndex(1));
        l.display();

    }

}
