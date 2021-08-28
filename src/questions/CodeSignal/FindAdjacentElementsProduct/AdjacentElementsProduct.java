package questions.CodeSignal.FindAdjacentElementsProduct;

public class AdjacentElementsProduct {

    public static int adjacentElementsProduct(int[] inputArray) {

        if (inputArray.length == 1) {
            return 0;
        }

        int maxProduct = inputArray[0] * inputArray[1];

        for (int i = 1; i < inputArray.length - 1; i++) {
            int adjacentProduct = inputArray[i] * inputArray[i + 1];

            if (adjacentProduct > maxProduct) {
                maxProduct = adjacentProduct; // re-assign product as max product
            }
        }

        return maxProduct;

    }

    public static void main(String[] args) {

        int[] arr = {3, 6, -2, -5, 7, 3};
        int maxProduct = adjacentElementsProduct(arr);
        System.out.println(maxProduct);

    }

}
