package main.algo.sort.bubble;

public class BubbleSort {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int flag = 0;

            // bubble pass
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1; // swapping occurred
                }
            }

            // exit when no swapping occurred in a pass
            if (flag == 0) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {15, 16, 6, 8, 5};
        printArray(arr);

        bubbleSort(arr);
        printArray(arr);

    }

}
