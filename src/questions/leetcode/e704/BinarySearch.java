package questions.leetcode.e704;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return -1;
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {-1,0,3,5,9,12};
        printArray(arr);

        int result1 = search(arr, 9);
        System.out.println(result1);

        int result2 = search(arr, 2);
        System.out.println(result2);
    }

}
