package main.java.algo.search;

public class LinearSearch {

    public static int linearSearch(int[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            if(data[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void verify(int index) {
        if (index == -1) {
            System.out.println("Key was not found in the array");
        } else {
            System.out.println("Key found at index: " + index);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int result = linearSearch(arr, 12);
        verify(result);

        result = linearSearch(arr, 5);
        verify(result);

    }

}
