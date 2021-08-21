package main.java.algo.search;

// Iterative
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int first = 0;
        int last = arr.length - 1;

        while(first <=last){
            int mid = (first + last) / 2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return -1;
    }

    public static void verify(int index) {
        if (index == -1) {
            System.out.println("Key was not found in the array");
        } else {
            System.out.println("Key found at index: " + index);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int result = binarySearch(arr, 12);
        verify(result);

        result = binarySearch(arr, 5);
        verify(result);

    }

}
