// A Java expression that is not a method call should not be flagged as a format specifier mismatch.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Helper method that returns a string containing %s
    private static String makeString() {
        return "Hello %s";
    }
    
    public static void main(String[] args) {
        // Variant 2: Move string literal to a helper method
        String s = makeString();
        // Use a temporary variable for length
        int len = s.length();
        System.out.println("Length is: " + len);
    }
}