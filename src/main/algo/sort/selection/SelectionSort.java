package main.algo.sort.selection;

public class SelectionSort {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // find the min value index in the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the values. ignore if reached the end of the array.
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
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

        int[] arr = {5, 2, 7, 4, 3};
        printArray(arr);

        selectionSort(arr);
        printArray(arr);

    }

}
