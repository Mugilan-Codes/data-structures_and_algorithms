package main.ds.stack;

import java.util.Stack;

// O(n^2) time complexity
public class ReverseStack {
    private static void insertAtBottom(Stack<Integer> stack, Integer n) {
//        System.out.println("n = " + n);
        if (stack.size() == 0) {
            stack.push(n);
//            System.out.println("size 0 = " + stack);
            return;
        }

        Integer temp = stack.pop();
//        System.out.println("bottom insert = " + temp);
        insertAtBottom(stack, n);
        stack.push(temp);
//        System.out.println("stack = " + stack);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return;
        }

        Integer temp = stack.pop();
//        System.out.println("temp = " + temp);
        reverse(stack);
        insertAtBottom(stack, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
