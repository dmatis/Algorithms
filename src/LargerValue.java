public class LargerValue {
    public static double getLargerValue(double a, double b) {
        double aExpB = Math.pow(a,b);
        double bExpA = Math.pow(b,a);
        double result = 0;

        try {
            if (aExpB >= bExpA) {
                result = aExpB;
            } else result = bExpA;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + ": invalid values entered");
        }
        return result;
    }
}
