// A string literal matching the insecure pattern is present but never used as algorithm parameter in any cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Store literal in an array, then assign
        String[] algorithms = new String[3];
        algorithms[0] = "AES";
        algorithms[1] = "DES";
        algorithms[2] = "BLOWFISH";
        String notUsedForCrypto = algorithms[1];
        // Try-catch block around print (still no crypto)
        try {
            System.out.println("String value: " + notUsedForCrypto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}