// A method declared in a class named "RandomUtil" with a name starting with "generate" that does not return String should not be flagged as using weak random string generation.
package scensct.core.neg;

public class NegCase3 {
    // Outer class is not RandomUtil; inner class is used to satisfy scenario.
    public static class RandomUtil {
        // Method name starts with "generate" but returns int, not String.
        public static int generateRandomNumber(int bound) {
            return 42; // Return type mismatch ensures negative.
        }
    }
}