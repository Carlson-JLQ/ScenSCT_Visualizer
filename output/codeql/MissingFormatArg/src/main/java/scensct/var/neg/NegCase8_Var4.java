// A recognized format method call with known format specifiers but undetermined argument count should not be flagged.
package scensct.var.neg;

public class NegCase8_Var4 {
    static Object[] getArgs() {
        return new Object[]{"world"};
    }
    public static void main(String[] args) {
        // Variant 4: Control flow with condition that doesn't affect argument
        boolean flag = System.currentTimeMillis() % 2 == 0;
        if (flag) {
            String result = String.format("Hello %s", getArgs());
        } else {
            String result = String.format("Hello %s", getArgs());
        }
    }
}