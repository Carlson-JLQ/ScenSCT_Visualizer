// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String but contains no return statement in its body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static class RandomUtil {
        // Variant 5: Try-catch block that throws in try and catch, no return.
        public static String generateWithTryCatch() {
            try {
                throw new Error("Try block throw");
            } catch (Exception e) {
                throw new RuntimeException("Catch rethrow", e);
            }
        }
    }
}