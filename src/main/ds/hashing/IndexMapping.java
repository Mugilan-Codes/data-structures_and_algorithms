package main.ds.hashing;

// Trivial Hashing with negatives allowed
public class IndexMapping {

    private static final int MAX_VALUE = 1000;

    // [][0] is positive; [][1] is negative
    private static final boolean[][] hash = new boolean[MAX_VALUE + 1][2];

    public static void populateHash(int[] arr) {
        for (int item : arr) {
            if (item >= 0) {
                hash[item][0] = true;
            } else {
                int absValue = Math.abs(item);
                hash[absValue][1] = true;
            }
        }
    }

    private static boolean search(int n) {
        if (n >= 0) {
            return hash[n][0];
        }

        n = Math.abs(n); // remove the sign from negative
        return hash[n][1];
    }

    public static void isPresent(int num) {
        if (search(num)) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 9, -5, -8, -5, -2, 5};

        populateHash(arr);

        isPresent(-5);
        isPresent(-10);
        isPresent(3);
        isPresent(9);
    }

}
