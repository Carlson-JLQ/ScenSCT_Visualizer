// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement that returns a method call, and that called method is either not from org.apache.commons.lang.RandomStringUtils or org.apache.commons.lang3.RandomStringUtils, or is the method named "random" from those classes should not be flagged as using weak random string generation.
package scensct.core.neg;

import java.util.UUID;

public class NegCase7 {
    // Outer class is not RandomUtil; inner class is used to satisfy scenario.
    public static class RandomUtil {
        // Method name starts with "generate", returns String, body is singleton block with return of method call, but called method is not from RandomStringUtils.
        public static String generateUUID() {
            return UUID.randomUUID().toString(); // Method call, but not from RandomStringUtils, ensures negative.
        }
    }
}