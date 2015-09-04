import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

public class ListPerformance {
    /** Test variables **/
    private final static int WARMUP = 1000;
    private final static int RUNS = 100;
    private final static int SIZE = 10000;

    public ListPerformance() {
        perfWarmup();
        perfTest();
    }

    private void perfTest() {
        long linkedListTime = buildLinkedList(SIZE);
        System.out.println("The LinkedList performance time is: " + linkedListTime);
        long arrayListTime = buildArrayList(SIZE);
        System.out.println("The ArrayList performance time is: " + arrayListTime);
        String winner = computeWinner(linkedListTime, arrayListTime);
        System.out.println("The faster data structure for adding " + SIZE + " elements is: " + winner);
    }

    private String computeWinner(long linkedListTime, long arrayListTime) {
        if (linkedListTime < arrayListTime) {
            return "LinkedList";
        } else return "ArrayList";
    }

    /** Warm up the JVM for optimization **/
    private void perfWarmup() {
        for (int i = 0; i < WARMUP; ++i) {
            buildLinkedList(1000);
        }
    }

    /** Fisher-Yates Shuffle for producing random values **/
    int[] sample(int sampleSize, int startInclusive, int endExclusive) {
        int[] samples = new int[sampleSize];
        int[] range = IntStream.range(startInclusive, endExclusive).toArray();
        Random random = new Random();
        for (int i = 0, j = range.length; i < samples.length; i++) {
            int k = random.nextInt(j--);
            samples[i] = range[k];
            range[k] = range[j];
        }
        return samples;
    }

    public long buildLinkedList(int size) {
        long start = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int[] randValues = sample(size, 0, size);
        for (int e : randValues) {
            linkedList.add(e);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public long buildArrayList(int size) {
        long start = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int[] randValues = sample(size, 0, size);
        for (int e : randValues) {
            arrayList.add(e);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {

        ListPerformance perfThousand = new ListPerformance();
    }

}
