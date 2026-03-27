// A recognized format method call with known format specifiers but undetermined argument count should not be flagged.
package scensct.var.neg;

public class NegCase8_Var5 {
    static Object[] getArgs() {
        Object[] arr = new Object[1];
        arr[0] = "world";
        return arr;
    }
    public static void main(String[] args) {
        // Variant 5: Inlined array construction in helper, still indeterminable length
        String result = String.format("Hello %s", getArgs());
    }
}