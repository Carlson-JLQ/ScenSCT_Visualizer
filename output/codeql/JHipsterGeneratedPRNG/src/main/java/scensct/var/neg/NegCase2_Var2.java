// A method declared in a class named "RandomUtil" whose name does not start with "generate" should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase2_Var2 {
    // RandomUtil as a non-static inner class (requires instance).
    public class RandomUtil {
        // Instance method, name does not start with "generate".
        public String makeRandomString(int length) {
            if (length <= 0) {
                return "";
            }
            return "dummy";
        }
    }
}