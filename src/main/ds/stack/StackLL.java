package main.ds.stack;

// Linked List Implementation
public class StackLL {
    Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
        System.out.println(data + " inserted");
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        int removeTopNode = top.data;
        top = top.next;
        System.out.println(removeTopNode + " deleted");
        return removeTopNode;
    }

    @Override
    public String toString() {
        Node temp = top;
        StringBuilder printStr = new StringBuilder();

        while (temp != null) {
            if (temp == top) {
                printStr.append("[Top: ").append(temp.data).append("]-> ");
            } else if (temp.next == null) {
                printStr.append("[").append(temp.data).append("]");
            } else {
                printStr.append("[").append(temp.data).append("]-> ");
            }
            temp = temp.next;
        }

        return printStr.toString();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }

        System.out.println(this); // this calls @override toString() method
    }

    private static class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

}

class TestStackLL {
    public static void main(String[] args) {
        StackLL stackLL = new StackLL();

        System.out.println(stackLL.isEmpty());

        stackLL.push(10);
        System.out.println(stackLL.peek());

        System.out.println(stackLL.isEmpty());

        stackLL.push(20);
        stackLL.push(30);
        stackLL.push(40);
        stackLL.display();
        stackLL.push(50);
        stackLL.push(60);
        stackLL.push(70);
        System.out.println(stackLL.peek());

        stackLL.display();

        System.out.println(stackLL.pop());
        System.out.println(stackLL.peek());

        stackLL.display();

    }
}