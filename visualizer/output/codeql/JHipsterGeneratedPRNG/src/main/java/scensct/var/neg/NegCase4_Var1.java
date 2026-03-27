// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String but contains no return statement in its body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static class RandomUtil {
        // Variant 1: Method with empty body (no explicit throw) - still no return.
        public static String generateNothing() {
            // Empty body; will not compile normally, but for static analysis it's valid.
            throw new UnsupportedOperationException("Not implemented");
        }
    }
}