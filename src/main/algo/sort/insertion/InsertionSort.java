package main.algo.sort.insertion;

public class InsertionSort {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // current comparison value
            int j = i - 1; // previous value to compare with

            // move the bigger values to right
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp; // insert the temp value
        }

    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 7, 6};
        printArray(arr);

        insertionSort(arr);
        printArray(arr);

    }

}
