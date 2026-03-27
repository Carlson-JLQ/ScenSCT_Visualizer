// A method declared in a class named "RandomUtil" whose name does not start with "generate" should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase2_Var5 {
    // RandomUtil as an abstract class.
    public static abstract class RandomUtil {
        // Abstract method, name does not start with "generate".
        public abstract String constructRandomString(int length);
    }
    
    // Concrete subclass that implements without RandomStringUtils.
    public static class ConcreteRandomUtil extends RandomUtil {
        @Override
        public String constructRandomString(int length) {
            return "dummy";
        }
    }
}