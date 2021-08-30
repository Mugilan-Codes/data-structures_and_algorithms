package questions.codesignal.firstduplicate;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicate {

    // Time Complexity: O(1) time or Constant Time
    // Space Complexity: O(n) space or Linear Space
    public static int firstDuplicate(int[] a) {
        // initialize hash set. since it does not hold duplicates
        Set<Integer> set = new HashSet<>();

        // loop through the array and add each element to the set
        for (int j : a) {
            // when the element cannot be added to the set the duplicate value is found
            if (!set.add(j)) {
                return j;
            }
        }

        // there are no duplicates
        return -1;
    }

    public static void main(String[] args) {

        int[] a = {2, 1, 3, 5, 3, 2};
        System.out.println(firstDuplicate(a));

        int[] b = {2, 2};
        System.out.println(firstDuplicate(b));

        int[] c = {2, 4, 3, 5, 1};
        System.out.println(firstDuplicate(c));

    }

}
