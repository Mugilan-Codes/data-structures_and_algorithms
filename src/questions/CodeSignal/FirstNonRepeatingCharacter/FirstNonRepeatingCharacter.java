package questions.CodeSignal.FirstNonRepeatingCharacter;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    // O(2n) time ~ O(n) time
    public static char firstNotRepeatingCharacter(String s) {

//        HashMap<Character, Integer> counts = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (counts.containsKey(c)) {
//                counts.put(c, counts.get(c) + 1);
//            } else {
//                counts.put(c, 1);
//            }
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (counts.get(c) == 1) {
//                return c;
//            }
//        }

        int[] counts = new int[26]; // create 26 alphabet index

        for (char c: s.toCharArray()) {
            counts[c - 'a']++; // ASCII subtraction e.g. 'a' - 'a' is 0 index
        }

        for (char c: s.toCharArray()) {
            if (counts[c - 'a'] == 1) {
                return c;
            }
        }

        return '_';
    }

    public static void main(String[] args) {

        String s1 = "abacabad";
        System.out.println(firstNotRepeatingCharacter(s1));

        String s2 = "abacabaabacaba";
        System.out.println(firstNotRepeatingCharacter(s2));

    }

}
