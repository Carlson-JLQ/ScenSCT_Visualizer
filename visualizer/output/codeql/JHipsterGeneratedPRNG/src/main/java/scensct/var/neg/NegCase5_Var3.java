// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, contains a return statement in its body, but that return statement is not the only statement in a singleton block that forms the method body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase5_Var3 {
    public static class RandomUtil {
        // Variant 3: Use a try-finally block; the print is in try, return after.
        public static String generateWithLogging(int length) {
            try {
                System.out.println("Entering generation");
            } finally {
                // finally block runs before return
            }
            return "dummy";
        }
    }
}