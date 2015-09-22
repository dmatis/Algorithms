import java.util.Arrays;

public class InsertionSort {

    // O(n^2) in worst case, Omega(n) if already sorted (best case)
    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int j = i;
            while (j >= 0 && nums[j]>nums[j+1]) {
                int tempNum = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = tempNum;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] numsSorted = {1,2,3,4,5};
        int[] numsUnsorted = {3,1,4,5,2};

        insertionSort(numsSorted);
        insertionSort(numsUnsorted);

        System.out.println(Arrays.toString(numsSorted));
        System.out.println(Arrays.toString(numsUnsorted));
    }
}
