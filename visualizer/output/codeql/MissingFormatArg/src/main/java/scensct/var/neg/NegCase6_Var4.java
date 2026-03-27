// A recognized format method call with indeterminate format string should not be flagged.
package scensct.var.neg;

public class NegCase6_Var4 {
    // Variant 4: Format string aliased through an array, with try-catch noise
    public static void main(String[] args) {
        String[] holder = new String[1];
        holder[0] = args.length > 0 ? args[0] : "Hello %s";
        try {
            String result = String.format(holder[0], "world");
        } catch (Exception e) {
            // dummy handler, does not affect reachability
        }
    }
}