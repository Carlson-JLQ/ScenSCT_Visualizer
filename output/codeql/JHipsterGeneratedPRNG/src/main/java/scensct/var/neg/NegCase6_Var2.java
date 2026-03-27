// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement, and the returned expression is not a method call should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase6_Var2 {
    public static class RandomUtil {
        // Variant 2: Use a ternary operator with a constant condition.
        public static String generateConstant() {
            return true ? "constant" : "not constant";
        }
    }
}