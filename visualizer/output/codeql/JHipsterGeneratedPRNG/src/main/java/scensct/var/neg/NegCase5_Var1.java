// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, contains a return statement in its body, but that return statement is not the only statement in a singleton block that forms the method body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static class RandomUtil {
        // Variant 1: Control-flow restructuring with if-else, but extra statement remains.
        public static String generateWithLogging(int length) {
            if (length > 0) {
                System.err.println("Length positive");
            } else {
                System.err.println("Length non-positive");
            }
            return "dummy";
        }
    }
}