// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement that returns a method call, and that called method is either not from org.apache.commons.lang.RandomStringUtils or org.apache.commons.lang3.RandomStringUtils, or is the method named "random" from those classes should not be flagged as using weak random string generation.
package scensct.var.neg;

import java.util.UUID;

public class NegCase7_Var3 {
    public static class RandomUtil {
        // Variant 3: Wrap the call in a try-catch block (unlikely to throw, but changes structure).
        public static String generateUUID() {
            try {
                return UUID.randomUUID().toString();
            } catch (Exception e) {
                throw new RuntimeException("UUID generation failed", e);
            }
        }
    }
}