package questions.CodeSignal.CheckPalindrome;

public class CheckPalindrome {

    public static boolean checkPalindrome(String str) {

        if (str.length() == 1) {
            return true;
        }

        int i = 0; // left side index
        int j = str.length() - 1; // right side index

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;

    }

    public static void main(String[] args) {

        String s1 = "aabaa";
        boolean p1 = checkPalindrome(s1);
        System.out.println(s1 + " is" + (p1 ? "" : " Not") + " palindrome");

        String s2 = "abac";
        boolean p2 = checkPalindrome(s2);
        System.out.println(s2 + " is" + (p2 ? "" : " Not") + " palindrome");

        String s3 = "a";
        boolean p3 = checkPalindrome(s3);
        System.out.println(s3 + " is" + (p3 ? "" : " Not") + " palindrome");

    }

}
