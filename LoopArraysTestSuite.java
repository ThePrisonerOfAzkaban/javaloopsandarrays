import java.util.Arrays;

public class LoopArraysTestSuite {

    public static void main(String[] args) {
        System.out.println("Running tests...");

        fibTests();
        maximumTests();
        frequencyTableTests();
        matrixMultiplyTests();

        System.out.println("...tests complete.");
    }

    public static void fibTests() {
        testFib(5, 5);
        testFib(1, 1);
        testFib(2, 1);
        testFib(8, 21);
        testFib(7, 13);
               
    }

    public static void maximumTests() {
        testMaximum(new int[] { 1, 3, 2 }, 3);
        testMaximum(new int[] { 543, 0, -153 }, 543);
        testMaximum(new int[] { 1,-4335475,-453742}, 1);
        testMaximum(new int[] { 354354,4543387,4563647}, 4563647);

    }

    public static void frequencyTableTests() {
        testFrequencyTable(-1.5, 1.5, 6
                          ,new double[] { -1.1, 1.1, 1.2, -0.8, 1.6 }
                          ,new int[] { 1, 1, 0, 0, 0, 2 });
        // TODO add test cases for frequencyTable here
    }

    public static void matrixMultiplyTests() {

        testMatrixMultiply(new double[][] { { 1, 2, 3, 4 }
                                          , { 5, 6, 7, 8 }
                                          , { 9, 1, 2, 3 }
                                          }
                          ,new double[][] { { 1, 2, 3 }
                                          , { 4, 5, 6 }
                                          , { 7, 8, 9 }
                                          , { 1, 2, 3 }
                                          }
                          , new double[][] { { 34, 44, 54 }
                                           , { 86, 112, 138 }
                                           , { 30, 45, 60 } });
        // TODO add test cases for matrix multiply here
    }

    private static final double EPSILON = 0.001;

    private static boolean approxEqualDouble(double a, double b) {
      return a == b
          || Math.abs(a - b) / Math.max(Math.abs(a), Math.abs(b)) < EPSILON;
    }

    private static boolean approxEqualDoubleArrays(double[][] x, double[][] y) {
        // TODO
        System.out.println("TODO: implement equal nested double arrays");
        return false;
    }

    private static void testFib(int n, int expected) {
        int actual = LoopArraysLibrary.fib(n);
        if (expected != actual) {
            System.out.println("fib(" + n + "); expected: " + expected
                    + " got: " + actual);
        }
    }

    private static void testMaximum(int[] vs, int expected) {
        int actual = LoopArraysLibrary.maximum(vs);
        if (expected != actual) {
            System.out.println("maximum(" + Arrays.toString(vs)
                    + "); expected: " + expected + " got: " + actual);
        }
    }

    private static void testFrequencyTable(double minimum, double maximum,
            int numBuckets, double[] data, int[] expected) {
        int[] actual = LoopArraysLibrary.frequencyTable(minimum, maximum,
                numBuckets, data);

        if (!Arrays.equals(expected, actual)) {
            System.out.println("frequencyTable(" + minimum + ", " + maximum
                    + ", " + numBuckets + ", " + Arrays.toString(data)
                    + "); expected: " + Arrays.toString(expected) + " got: "
                    + Arrays.toString(actual));
        }
    }

    private static void testMatrixMultiply(double[][] m, double[][] n,
            double[][] expected) {
        double[][] actual = LoopArraysLibrary.matrixMultiply(m, n);

        if (!approxEqualDoubleArrays(expected, actual)) {
            System.out.println("matrixMultiply(" + Arrays.deepToString(m)
                    + ", " + Arrays.deepToString(n) + "); expected: "
                    + Arrays.deepToString(expected) + ", got: "
                    + Arrays.deepToString(actual));
        }
    }

}
