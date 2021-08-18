package main.java;

public class RecursiveBinarySearch {

    public static int binarySearch(int[] arr, int target, int start, int end) {

        if (start >= end) {
            return -1;
        } else {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, target, start, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, end);
            }
        }

    }

    public static void verify(int index) {
        if (index == -1) {
            System.out.println("Key was not found in the array");
        } else {
            System.out.println("Key found at index: " + index);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = binarySearch(arr, 12, 0, arr.length - 1);
        verify(result);

        result = binarySearch(arr, 5, 0, arr.length - 1);
        verify(result);

    }

}
