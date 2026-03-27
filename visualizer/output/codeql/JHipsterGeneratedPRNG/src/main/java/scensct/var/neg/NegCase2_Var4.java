// A method declared in a class named "RandomUtil" whose name does not start with "generate" should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase2_Var4 {
    // RandomUtil as an interface with a default method (Java 8+).
    public interface RandomUtil {
        // Default method name does not start with "generate".
        default String produceRandomString(int length) {
            return "dummy";
        }
    }
    
    // Provide an implementing class to make it concrete.
    public static class RandomUtilImpl implements RandomUtil {
        // No violation: method is inherited default, still not starting with "generate".
    }
}