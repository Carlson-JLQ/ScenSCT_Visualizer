// A method declared in a class named "RandomUtil" whose name does not start with "generate" should not be flagged as using weak random string generation.
package scensct.core.neg;

public class NegCase2 {
    // Outer class is not RandomUtil; inner class is used to satisfy scenario.
    public static class RandomUtil {
        // Method name does not start with "generate".
        public static String createRandomString(int length) {
            return "dummy"; // Not a RandomStringUtils call, and method name mismatch ensures negative.
        }
    }
}