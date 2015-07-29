import java.util.Scanner;

public class ArrayInputScanner {

    public static void main(String args[]) {

        System.out.println("Please provide a set of integers, separated by commas");
        System.out.println("Then press ENTER to start");

        Scanner in = new Scanner(System.in);
        String line;
        String[] lineVector;
        line = in.nextLine(); //reads input (ie 1,2,3)

        //separate all values by comma
        lineVector = line.split(",");
        int[] inputArray = new int[lineVector.length];

        // parse all values as integers into inputArray
        for (int i = 0; i < lineVector.length; i++) {
            inputArray[i] = Integer.parseInt(lineVector[i]);
            System.out.println(inputArray[i]);
        }
        in.close();
        System.out.println("Done!");
    }
}
