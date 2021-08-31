package main.algo.sort.merge;

public class MergeSort {

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int low, int high) {
        // sublist at least has 2 elements
        if (low < high) {
            int midIndex = low + ((high - low) / 2); // (low + high) / 2
            mergeSortHelper(arr, low, midIndex); // divide into sub lists (left side)
            mergeSortHelper(arr, midIndex + 1, high); // divide into sub lists (right side)
            merge(arr, low, midIndex, high); // conquer and combine the sub lists
        }
    }

    // Theta(m + n)
    private static void merge(int[] arr, int low, int mid, int high) {
        // get the size of the sublist
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        // create sublist and copy the contents to it
        int[] leftSublist = new int[leftSize];
        int[] rightSublist = new int[rightSize];

        // can use System.arraycopy() too
        for (int i = 0; i < leftSize; i++) {
            leftSublist[i] = arr[low + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightSublist[i] = arr[mid + 1 + i];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int placeIndex = low; // keep track of where to place the sorted element

        // compare and sort the left sublist with right sublist
        // exit when one of the sublist index reaches its end
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftSublist[leftIndex] <= rightSublist[rightIndex]) {
                arr[placeIndex] = leftSublist[leftIndex];
                leftIndex++;
            } else {
                arr[placeIndex] = rightSublist[rightIndex];
                rightIndex++;
            }
            placeIndex++;
        }

        // copy over the remaining content from a larger sublist
        while (leftIndex < leftSize) {
            arr[placeIndex] = leftSublist[leftIndex];
            leftIndex++;
            placeIndex++;
        }
        while (rightIndex < rightSize) {
            arr[placeIndex] = rightSublist[rightIndex];
            rightIndex++;
            placeIndex++;
        }

    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i + 1] == n) {
                break;
            }
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {50, 43, 8, 123, 9, 4, 87, 3};
        printArray(arr);
        System.out.println(isSorted(arr));

        mergeSort(arr);
        printArray(arr);
        System.out.println(isSorted(arr));

    }

}
