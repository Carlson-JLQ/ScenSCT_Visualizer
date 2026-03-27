// A non-format method call with enclosing String and Object[] parameters not used for formatting should not be flagged.
package scensct.var.neg;

public class NegCase5_Var5 {
    // Variant 5: Complex control flow with try-catch and aliasing
    static void forward(String fmt, Object[] args) {
        try {
            String message = fmt.toUpperCase();
            System.out.println(message);
            // args not used in formatting
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String formatString = "Hello %s";
        Object[] arguments = new Object[]{"world"};
        forward(formatString, arguments);
    }
}