// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement that returns a method call, and that called method is either not from org.apache.commons.lang.RandomStringUtils or org.apache.commons.lang3.RandomStringUtils, or is the method named "random" from those classes should not be flagged as using weak random string generation.
package scensct.var.neg;

import java.util.UUID;

public class NegCase7_Var2 {
    public static class RandomUtil {
        // Variant 2: Use a static initializer to define a helper method (still within the inner class).
        private static String helper() {
            return UUID.randomUUID().toString();
        }
        
        public static String generateUUID() {
            return helper(); // Delegates to helper, still not RandomStringUtils.
        }
    }
}