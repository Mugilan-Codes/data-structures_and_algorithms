package questions.codesignal.consecutivearray;

import java.util.Arrays;

public class ConsecutiveArray {

    public static int makeArrayConsecutive2(int[] statues) {
        int N = statues.length;
        if (N < 2) return 0;

        // compare and track min and max of first two value in array
        int min = Math.min(statues[0], statues[1]);
        int max = Math.max(statues[0], statues[1]);

        // compare and alter min and max with each item
        for (int i = 2; i < N; i++) {
            min = Math.min(min, statues[i]);
            max = Math.max(max, statues[i]);
        }

        // max - min + 1 : gives the count of numbers (e.g. 2 to 8 is 7 nos.)
        return max - min + 1 - N;
    }

    public static void main(String[] args) {
        int[] statues = {6, 2, 3, 8};
        System.out.println(Arrays.toString(statues));
        System.out.println(makeArrayConsecutive2(statues));
    }

}
