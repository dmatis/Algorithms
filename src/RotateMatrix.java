import java.util.Arrays;

public class RotateMatrix {

    /*
         top
      ********* r
    l *&&&&&&&* i
    e *&%%%%%&* g
    f *&&&&&&&* h
    t ********* t
        bottom
     */

    // Rotates a matrix of size n clockwise
    public static void rotate(int[][] matrix, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Must provide a matrix of size n >= 1");
        }

        if (n == 1) {
            return;
        }

        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                // saves the top part
                int top = matrix[first][i];
                // left moves to top
                matrix[first][i] = matrix[last-offset][first];
                // bottom moves to left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right moves to the bottom
                matrix[last][last-offset] = matrix[i][last];
                // top moves to right
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[] one = {1,2,3,4};
        int[] two = {5,6,7,8};
        int[] three = {9,10,11,12};
        int[] four = {13,14,15,16};

        int[][] fourMatrix = {one,two,three,four};

        for (int i = 0; i < fourMatrix.length; i++) {
            System.out.println(Arrays.toString(fourMatrix[i]));
        }

        System.out.println("-------AFTER ROTATION-----------");

        rotate(fourMatrix, 4);

        for (int i = 0; i < fourMatrix.length; i++) {
            System.out.println(Arrays.toString(fourMatrix[i]));
        }
    }
}
