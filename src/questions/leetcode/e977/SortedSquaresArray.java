package questions.leetcode.e977;

public class SortedSquaresArray {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int positive = 0;
        while (positive < n && nums[positive] < 0) {
            positive++;
        }

        int negative = positive-1;

        int[] sortedSquares = new int[n];
        int counter = 0;

        while (negative >= 0 && positive < n) {
            if (nums[negative] * -1 < nums[positive]) {
                sortedSquares[counter] = nums[negative] * nums[negative];
                negative--;
            } else {
                sortedSquares[counter] = nums[positive] * nums[positive];
                positive++;
            }
            counter++;
        }

        while (negative >= 0) {
            sortedSquares[counter] = nums[negative] * nums[negative];
            counter++;
            negative--;
        }

        while (positive < n) {
            sortedSquares[counter] = nums[positive] * nums[positive];
            counter++;
            positive++;
        }

        return sortedSquares;
    }

    public static void printArray(int[] arr) {
        for(int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {-4,-1,0,3,10};
        printArray(arr1);
        int[] result1 = sortedSquares(arr1);
        printArray(result1);

        int[] arr2 = {-7,-3,2,3,11};
        printArray(arr2);
        int[] result2 = sortedSquares(arr2);
        printArray(result2);

    }

}
