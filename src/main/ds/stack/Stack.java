package main.ds.stack;

public class Stack {

    private int[] arr;
    private int capacity;
    private int top;

    Stack(int sizeOfStack) {
        arr = new int[sizeOfStack];
        capacity = sizeOfStack;
        top = -1;
    }

    public void push(int n) {
        if(isFull()) {
            System.out.println("Overflow");
            return;
        }

        System.out.println("Inserting: " + n);
        arr[++top] = n; // increment the top pointer and store the value in that position
    }
    public int pop() {
        if(isEmpty()) {
            System.out.println("Underflow");
            return 0;
        }

        System.out.println("Removing: " + arr[top]);
        return arr[top--];
    }

    public Boolean isEmpty() {
        return top == -1;
    }
    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void peek() {}

    public void display() {
        for (int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}

class TestStack {
    public static void main(String[] args) {
        Stack s = new Stack(5);

        System.out.println(s.isEmpty());
        System.out.println(s.isFull());

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.display();
        s.push(60);
        s.display();
        System.out.println(s.pop());
        s.display();
        s.push(70);
        s.display();
    }
}
