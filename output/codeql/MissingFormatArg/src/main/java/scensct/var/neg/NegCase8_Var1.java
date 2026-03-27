// A recognized format method call with known format specifiers but undetermined argument count should not be flagged.
package scensct.var.neg;

public class NegCase8_Var1 {
    static Object[] fetchArguments() {
        return new Object[]{"world"};
    }
    public static void main(String[] args) {
        // Variant 1: Renamed method and variable, same logic
        Object[] params = fetchArguments();
        String result = String.format("Hello %s", params);
    }
}