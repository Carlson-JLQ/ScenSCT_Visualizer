// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement that returns a method call, and that called method is either not from org.apache.commons.lang.RandomStringUtils or org.apache.commons.lang3.RandomStringUtils, or is the method named "random" from those classes should not be flagged as using weak random string generation.
package scensct.var.neg;

import java.util.UUID;

public class NegCase7_Var4 {
    public static class RandomUtil {
        // Variant 4: Use a conditional that always takes the same branch (dead code elimination challenge).
        public static String generateUUID() {
            if (System.currentTimeMillis() > 0) { // Always true.
                return UUID.randomUUID().toString();
            }
            return ""; // Unreachable, but preserves return type.
        }
    }
}