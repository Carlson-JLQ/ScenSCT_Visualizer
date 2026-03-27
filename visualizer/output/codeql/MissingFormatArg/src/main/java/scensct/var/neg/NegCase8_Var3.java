// A recognized format method call with known format specifiers but undetermined argument count should not be flagged.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase8_Var3 {
    static Object[] getArgs() {
        return new Object[]{"world"};
    }
    public static void main(String[] args) {
        // Variant 3: Using Formatter class directly, same indeterminable argument
        try (Formatter fmt = new Formatter()) {
            fmt.format("Hello %s", getArgs());
        }
    }
}