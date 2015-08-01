import java.util.Scanner;

public class MergeSort {

    private int[] array;
    private int[] tempArray;
    private int length;

    public static void main(String args[]) {

        System.out.println("Please provide a set of integers to sort, separated by commas");
        System.out.println("Then press ENTER to start");

        int[] inputArray = ArrayInputScanner.createArray(new Scanner(System.in));

        MergeSort ms = new MergeSort();
        ms.sort(inputArray);

        /*
        Why does inputArray contain the same values as ms.array after sort operation
        It appears that only ms.array values gets updated during sort function
         */

        for(int i:inputArray) {
            System.out.print(i + " ");
        }

        System.out.println("Done!");
    }

    public void sort(int[] inputArray) {
        this.array = inputArray;
        this.length = inputArray.length;
        this.tempArray = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lower, int upper) {
        
        if (lower < upper) {
            // middle is the int index that the arrays split at
            int middle = lower + (upper - lower) / 2;
            doMergeSort(lower, middle);
            doMergeSort(middle+1, upper);
            // joins the 2 arrays back together
            mergeArrays(lower, middle, upper);
        }
    }

    private void mergeArrays(int lower, int middle, int upper) {

        // instantiates the correct array size for tempArray
        System.arraycopy(array, 0, tempArray, 0, upper + 1);
        int i = lower;
        int j = middle + 1;
        int k = lower;
        // comparison occurs here, the lesser of i and j goes into final array slot
        while (i <= middle && j <= upper) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }
}
