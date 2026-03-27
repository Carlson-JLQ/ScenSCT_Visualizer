// A method declared in a class named "RandomUtil" whose name does not start with "generate" should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase2_Var1 {
    // RandomUtil as a top-level static nested class, but method uses a helper.
    public static class RandomUtil {
        // Method name still does not start with "generate".
        public static String createRandomString(int len) {
            String result = buildDummy(len);
            return result;
        }
        
        private static String buildDummy(int length) {
            return "dummy";
        }
    }
}