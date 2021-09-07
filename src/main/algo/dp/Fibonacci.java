package main.algo.dp;

public class Fibonacci {

    // sub-problems is solved again and again
    // Takes O(2^n) time and O(n) space
    public static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    // Iterative / Bottom-Up Approach
    // Takes O(n) time and O(1) space
    public static int fibonacciBottomUp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1, c;
        for (int i = 2; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    // Recursive Memoization / Top-Down Approach
    // Takes O(n) time and O(n) space
    public static int fibonacciTopDown(int n, int[] fib) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = fibonacciTopDown(n - 1, fib) + fibonacciTopDown(n - 2, fib);

        return fib[n];

    }

    public static void main(String[] args) {
        int n = 10; // nth position number in fibonacci series
        System.out.println(fibonacciRecursion(n));
        System.out.println(fibonacciBottomUp(n));

        int[] fib = new int[n + 1];
        System.out.println(fibonacciTopDown(n, fib));
    }

}