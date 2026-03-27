// The format string argument in a String.format call originates from a non-user-provided source should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase3_Var3 {
    // Variant 3: Inter-procedural refactoring - helper method returns constant format
    private static String getFormat() {
        return "Constant: %d";
    }
    
    public static void main(String[] args) {
        int value = 42;
        // The format is still a constant returned from a method
        String result = String.format(getFormat(), value);
        System.out.println(result);
    }
}