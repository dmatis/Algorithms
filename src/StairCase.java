import java.util.Scanner;

public class StairCase {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        for (int i = 1; i < x+1; i++) {
            for (int k = 0; k < x-i; k++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

}
