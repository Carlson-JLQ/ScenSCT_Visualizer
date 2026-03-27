// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String but contains no return statement in its body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static class RandomUtil {
        // Variant 4: Loop that never exits (infinite loop) before any return.
        public static String generateInfinite() {
            while (true) {
                // Never returns.
            }
        }
    }
}