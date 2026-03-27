// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement, and the returned expression is not a method call should not be flagged as using weak random string generation.
package scensct.core.neg;

public class NegCase6 {
    // Outer class is not RandomUtil; inner class is used to satisfy scenario.
    public static class RandomUtil {
        // Method name starts with "generate", returns String, body is a singleton block with only return, but returned expression is not a method call.
        public static String generateConstant() {
            return "constant"; // Literal, not a method call, ensures negative.
        }
    }
}