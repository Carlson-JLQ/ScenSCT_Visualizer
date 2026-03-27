// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String but contains no return statement in its body should not be flagged as using weak random string generation.
package scensct.core.neg;

public class NegCase4 {
    // Outer class is not RandomUtil; inner class is used to satisfy scenario.
    public static class RandomUtil {
        // Method name starts with "generate", returns String, but has no return statement.
        public static String generateEmpty() {
            // No return statement; will not compile normally, but for static analysis, it's a valid method declaration.
            throw new RuntimeException("No return"); // Added to make compilable; scenario focuses on missing return.
        }
    }
}