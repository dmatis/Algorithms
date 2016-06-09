public class QuickSort {

    public static int[] qsort(int[] arr) {
        return qsort(arr, 0, arr.length-1);
    }

    public static int[] qsort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        int[] sortedArray = arr;
        if (left < index - 1) {
            sortedArray = qsort(arr, left, index - 1);
        }
        if (index + 1 < right) {
            sortedArray = qsort(arr, index+1, right);
        }
        return sortedArray;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int pIndex = left;
        while (left < right) {
            while (arr[left] > pivot) {
                left++;
            }
            if (left < right) {
                swapElements(arr, pIndex, left);
                pIndex++;
                left++;
            }
        }
        swapElements(arr, pIndex, right);
        return pIndex;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        if (indexA == indexB) {
            return;
        }
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("}\n");
    }

    public static void main(String[] args) {
        int[] testArray = {1,6,3,7,5,2,4,9};
        int[] array1 = {5,8,3,6,2,4};
        int[] array2 = {6,5,1,3,8,4,7,9,2};
        int[] largeArray = {54,23,78,41,99,2,31,46,52,23};
        printArray(qsort(testArray));
        //printArray(qsort(array1));
        //printArray(qsort(largeArray));
    }
}
