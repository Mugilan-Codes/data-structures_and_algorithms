package main.maths;

public class CountTrailingZeroes {

    public static int findTrailingZeroes(int num) {
        if (num < 0) {
            return -1;
        }

        int noOfFives = 0;

        // count the no. of 5's used in finding factorial of num (factors of 5)
        // REF: Legendre's Formula - https://artofproblemsolving.com/wiki/index.php/Legendre%27s_Formula
        for (int i = 5; i <= num; i *= 5) {
            noOfFives += num / i;
        }

        return noOfFives;
    }

    public static void main(String[] args) {
        System.out.println(findTrailingZeroes(5));
        System.out.println(findTrailingZeroes(10));
        System.out.println(findTrailingZeroes(25));
        System.out.println(findTrailingZeroes(125));
    }

}
