// A method declared in a class named "RandomUtil" with a name starting with "generate" that does not return String should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static class RandomUtil {
        // Variant 1: Change return type to long, add a parameter and a loop.
        public static long generateRandomLong(int bound) {
            long result = 0L;
            for (int i = 0; i < bound; i++) {
                result += i;
            }
            return result;
        }
    }
}