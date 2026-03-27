// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement, and the returned expression is not a method call should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static class RandomUtil {
        // Variant 3: Wrap the return in a try-finally block that does nothing.
        public static String generateConstant() {
            try {
                return "constant";
            } finally {
                // No-op
            }
        }
    }
}