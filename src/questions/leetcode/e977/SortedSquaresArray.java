package questions.leetcode.e977;

public class SortedSquaresArray {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int positiveIndex = 0;
        // find the index of the first positive number
        while (positiveIndex < n && nums[positiveIndex] < 0) {
            positiveIndex++;
        }

        // negative index will be decreasing to 0th position in array
        int negativeIndex = positiveIndex - 1;

        int[] sortedSquares = new int[n];
        int counter = 0;

        // sort and square the numbers into new array
        while (negativeIndex >= 0 && positiveIndex < n) {
            if (nums[negativeIndex] * -1 < nums[positiveIndex]) {
                sortedSquares[counter] = nums[negativeIndex] * nums[negativeIndex];
                negativeIndex--;
            } else {
                sortedSquares[counter] = nums[positiveIndex] * nums[positiveIndex];
                positiveIndex++;
            }
            counter++;
        }

        // square and copy over the remaining numbers
        while (negativeIndex >= 0) {
            sortedSquares[counter] = nums[negativeIndex] * nums[negativeIndex];
            counter++;
            negativeIndex--;
        }
        while (positiveIndex < n) {
            sortedSquares[counter] = nums[positiveIndex] * nums[positiveIndex];
            counter++;
            positiveIndex++;
        }

        return sortedSquares;
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {-4, -1, 0, 3, 10};
        printArray(arr1);
        int[] result1 = sortedSquares(arr1);
        printArray(result1);

        int[] arr2 = {-7, -3, 2, 3, 11};
        printArray(arr2);
        int[] result2 = sortedSquares(arr2);
        printArray(result2);

    }

}
