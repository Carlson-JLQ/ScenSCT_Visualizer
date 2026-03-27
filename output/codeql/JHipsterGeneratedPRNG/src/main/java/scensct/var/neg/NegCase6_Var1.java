// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement, and the returned expression is not a method call should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static class RandomUtil {
        // Variant 1: Use a local variable to hold the literal, then return it.
        public static String generateConstant() {
            final String constant = "constant";
            return constant;
        }
    }
}