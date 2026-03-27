// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, contains a return statement in its body, but that return statement is not the only statement in a singleton block that forms the method body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase5_Var5 {
    public static class RandomUtil {
        // Variant 5: Loop before return (even if zero iterations), plus an extra statement.
        public static String generateWithLogging(int length) {
            for (int i = 0; i < 0; i++) {
                // never runs
            }
            System.out.println("Generating");
            return "dummy";
        }
    }
}