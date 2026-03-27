// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, contains a return statement in its body, but that return statement is not the only statement in a singleton block that forms the method body should not be flagged as using weak random string generation.
package scensct.core.neg;

public class NegCase5 {
    // Outer class is not RandomUtil; inner class is used to satisfy scenario.
    public static class RandomUtil {
        // Method name starts with "generate", returns String, has return statement, but body is not a singleton block with only return.
        public static String generateWithLogging(int length) {
            System.out.println("Generating"); // Extra statement before return.
            return "dummy"; // Not a RandomStringUtils call, and body structure mismatch ensures negative.
        }
    }
}