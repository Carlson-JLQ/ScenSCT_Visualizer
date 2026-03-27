// A string literal matching the insecure pattern is present but never used as algorithm parameter in any cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase2_Var3 {
    // Helper method that returns the literal
    private static String getString() {
        return "DES";
    }

    public static void main(String[] args) {
        String notUsedForCrypto = getString();
        // Use in a conditional branch but still no crypto
        if (args.length > 0) {
            System.out.println("First arg: " + args[0]);
        } else {
            System.out.println("No args, but here's a string: " + notUsedForCrypto);
        }
    }
}