// A recognized format method call with specifier count <= argument count should not be flagged.
package scensct.var.neg;

public class NegCase9_Var3 {
    // Variant 3: Inter-procedural - extract format call to a helper method
    private static String formatGreeting(String name) {
        return String.format("Hello %s", name);
    }
    
    public static void main(String[] args) {
        String result = formatGreeting("world");
    }
}