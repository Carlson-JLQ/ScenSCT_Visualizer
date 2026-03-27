// A method declared in a class named "RandomUtil" with a name starting with "generate" that does not return String should not be flagged as using weak random string generation.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static class RandomUtil {
        // Variant 2: Return a custom object, use conditional logic.
        public static Result generateRandomResult(boolean flag) {
            if (flag) {
                return new Result(100);
            } else {
                return new Result(-1);
            }
        }
        
        static class Result {
            final int value;
            Result(int v) { this.value = v; }
        }
    }
}