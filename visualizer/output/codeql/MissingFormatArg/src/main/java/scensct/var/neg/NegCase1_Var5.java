// A Java expression that is not a method call should not be flagged as a format specifier mismatch.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Try-catch block with string operations, no formatting
        try {
            String s = new String(new char[] {'H','e','l','l','o',' ','%','s'});
            int length = s.length();
            if (length > 0) {
                System.out.println(s.substring(0, length));
            }
        } catch (Exception e) {
            // Still no format calls
            System.err.println("Error: " + e.getMessage());
        }
    }
}