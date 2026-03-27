// A method declared in a class named "RandomUtil" with a name starting with "generate" that does not return String should not be flagged as using weak random string generation.
package scensct.var.neg;

import java.util.Optional;

public class NegCase3_Var3 {
    public static class RandomUtil {
        // Variant 3: Return Optional<Integer>, use helper method.
        public static Optional<Integer> generateRandomOptional(int max) {
            int val = computeValue(max);
            return Optional.of(val);
        }
        
        private static int computeValue(int limit) {
            return limit > 0 ? limit % 100 : 0;
        }
    }
}