package questions.leetcode.m189;

public class RotateArray {

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int N = nums.length;

        k %= N; // makes sure k < N

        reverse(nums, 0, N - 1); // full array
        reverse(nums, 0, k - 1); // start to k elements
        reverse(nums, k, N - 1); // k+1 to end elements

    }

    public static void printArray(int[] arr) {
        for (int item:arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7};
        int k1 = 3;
        printArray(arr1);
        System.out.println("Rotated by " + k1 + " steps");
        rotate(arr1, k1);
        printArray(arr1);

        System.out.println();

        int[] arr2 = {-1,-100,3,99};
        int k2 = 2;
        printArray(arr2);
        System.out.println("Rotated by " + k2 + " steps");
        rotate(arr2, k2);
        printArray(arr2);

    }

}
