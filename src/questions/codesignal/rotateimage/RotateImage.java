package questions.codesignal.rotateimage;

import java.util.Arrays;

public class RotateImage {

    public static int[][] rotateImage(int[][] a) {
        int N = a.length; // rows = columns, since n x n matrix

        // transpose of the matrix
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // flip horizontally
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][N - 1 - j];
                a[i][N - 1 - j] = temp;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(rotateImage(arr)));
    }

}
