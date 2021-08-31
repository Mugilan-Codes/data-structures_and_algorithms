package questions.leetcode.e35;

import java.util.Arrays;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int first = 0, last = nums.length - 1;

        while (first <= last) {

            int mid = first + ((last - first) / 2);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

        }

        return first;

    }

    public static void main(String[] args) {

        int[] arr = {1,3,5,6};
        System.out.println(Arrays.toString(arr));
        System.out.println(searchInsert(arr, 5));
        System.out.println(searchInsert(arr, 2));
        System.out.println(searchInsert(arr, 7));
        System.out.println(searchInsert(arr, 0));

        arr = new int[] {1};
        System.out.println(searchInsert(arr, 0));

    }

}
