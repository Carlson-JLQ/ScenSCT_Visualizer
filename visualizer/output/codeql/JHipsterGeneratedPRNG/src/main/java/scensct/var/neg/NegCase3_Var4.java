// A method declared in a class named "RandomUtil" with a name starting with "generate" that does not return String should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static class RandomUtil {
        // Variant 4: void return type, method name starts with "generate".
        public static void generateLogMessage(String msg) {
            System.out.println("Log: " + msg);
        }
    }
}