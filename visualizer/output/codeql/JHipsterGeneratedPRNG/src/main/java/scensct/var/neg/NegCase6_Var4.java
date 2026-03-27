// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement, and the returned expression is not a method call should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase6_Var4 {
    public static class RandomUtil {
        // Variant 4: Use a switch expression to return the literal.
        public static String generateConstant() {
            return switch (1) {
                case 1 -> "constant";
                default -> throw new IllegalStateException();
            };
        }
    }
}