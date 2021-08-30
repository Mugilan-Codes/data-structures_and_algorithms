package main.algo.sort.quick;

public class QuickSort {

    // Time Complexity: O(n^2), Theta(n log n)
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1); // less than or equal to pivot
            quickSortHelper(arr, pivotIndex + 1, high); // greater than pivot
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int start = low;
        int end = high;

        while (start < end) {
            while (arr[start] <= pivot && start < high) {
                start++;
            }
            while (arr[end] > pivot && end > low) {
                end--;
            }

            if (start < end) {
                swap(arr, start, end);
            }
        }

        swap(arr, end, low); // swap with pivot position
        return end; // pivot index
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 8, 3, 9, 2, 4, 11};
        printArray(arr);

        quickSort(arr);
        printArray(arr);
    }

}
