// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, contains a return statement in its body, but that return statement is not the only statement in a singleton block that forms the method body should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase5_Var2 {
    public static class RandomUtil {
        // Variant 2: Introduce a temporary variable and a side-effect before return.
        public static String generateWithLogging(int length) {
            String prefix = "gen-";
            System.out.println(prefix + length);
            return "dummy";
        }
    }
}