import java.util.Scanner;

public class MergeSort {

    public static void main(String args[]) {

        System.out.println("Please provide a set of integers, separated by commas");
        System.out.println("Then press ENTER to start");

        Scanner in = new Scanner(System.in);
        String line;
        String[] lineVector;
        line = in.nextLine(); //reads input (ie 1,2,3)

        //separate all values by comma
        lineVector = line.split(",");
        int[] arrayA = new int[lineVector.length];

        for (int i = 0; i < lineVector.length; i++) {
            arrayA[i] = Integer.parseInt(lineVector[i]);
            System.out.println(arrayA[i]);
        }
        in.close();
        System.out.println("Done!");
    }
}
