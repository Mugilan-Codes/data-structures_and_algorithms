package questions.codesignal.polygonshapearea;

public class ShapeArea {

    public static int shapeArea(int n) {
        // 1 -> 1
        // 2 -> 1 + 2 ** 2
        // 3 -> 1 + 2 ** 2 + 2 ** 3
        // 4 -> 1 + 2 ** 2 + 2 ** 3 + 2 ** 4

        // Explanation:
        // - multiply 2 sides of polygon - side * side, since two sides overlap in polygons, deduct 1 from one side giving -> side * (side - 1)
        // - there are 4 sides to a polygon, so multiply the previous answer by 2.
        // - add 1 to the result to get the area of an n-interesting polygon
        // return 1 + 2 * n * (n - 1);

        // calculate the area of side n + area of side n-1
        // area of n is used to get the total number of 1-interesting polygon to append to the rim of the (n-1)-interesting polygon
        return (n * n) + ((n - 1) * (n - 1));
    }

    public static void main(String[] args) {
        int a1 = 2;
        int a1Area = shapeArea(a1);
        System.out.println(a1 + "-interesting polygon area is " + a1Area);

        int a2 = 3;
        int a2Area = shapeArea(a2);
        System.out.println(a2 + "-interesting polygon area is " + a2Area);

        int a3 = 6;
        int a3Area = shapeArea(a3);
        System.out.println(a3 + "-interesting polygon area is " + a3Area);
    }

}
