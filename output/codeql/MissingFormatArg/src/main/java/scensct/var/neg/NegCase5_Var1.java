// A non-format method call with enclosing String and Object[] parameters not used for formatting should not be flagged.
package scensct.var.neg;

public class NegCase5_Var1 {
    // Variant 1: Lexical refactoring with varargs and renamed elements
    static void logMessage(String template, Object... params) {
        // Still not using template as format string
        System.out.println("Template: " + template);
        System.out.println("Params count: " + params.length);
    }
    public static void main(String[] args) {
        logMessage("Hello %s", "world");
    }
}