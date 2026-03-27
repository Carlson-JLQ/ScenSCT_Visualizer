// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, contains a return statement in its body, but that return statement is not the only statement in a singleton block that forms the method body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase5_Var4 {
    public static class RandomUtil {
        // Variant 4: Extract the extra statement into a private static helper.
        private static void logGeneration() {
            System.out.println("Generating");
        }
        
        public static String generateWithLogging(int length) {
            logGeneration();
            return "dummy";
        }
    }
}