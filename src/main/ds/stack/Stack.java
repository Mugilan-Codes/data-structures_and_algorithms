package main.ds.stack;

public class Stack {

    private final int[] arr;
    private final int capacity;
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
        top++;
        arr[top] = n;
    }
    // removes last element from the stack
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

    // returns the last element in the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return top; // -1
        }
        return arr[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

}

class TestStack {
    public static void main(String[] args) {
        Stack s = new Stack(5);

        System.out.println(s.isEmpty());
        System.out.println(s.isFull());

        System.out.println(s.peek());

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

        System.out.println(s.peek());
    }
}
