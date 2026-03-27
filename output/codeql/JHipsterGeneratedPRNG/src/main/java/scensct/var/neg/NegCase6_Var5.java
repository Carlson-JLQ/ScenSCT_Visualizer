// A method declared in a class named "RandomUtil" with a name starting with "generate" that returns String, whose body is a singleton block containing only a return statement, and the returned expression is not a method call should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static class RandomUtil {
        // Variant 5: Extract the literal to a private static helper method that returns a constant.
        // The helper method name does not start with "generate", so it's not the target.
        private static String getConstant() {
            return "constant";
        }
        
        public static String generateConstant() {
            return getConstant(); // This is a method call, but not to Apache Commons RandomStringUtils.
            // The checker should not report because it's not the banned method.
        }
    }
}