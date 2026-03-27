// A method declared in a class named "RandomUtil" with a name starting with "generate" that does not return String should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static class RandomUtil {
        // Variant 5: Return int array, introduce try-catch-finally.
        public static int[] generateRandomArray(int size) {
            int[] arr = new int[size];
            try {
                for (int i = 0; i < size; i++) {
                    arr[i] = i * 2;
                }
            } catch (Exception e) {
                // ignore
            } finally {
                // cleanup placeholder
            }
            return arr;
        }
    }
}