// A string literal matching the insecure pattern is present but never used as algorithm parameter in any cryptographic operation should not be flagged as insecure crypto usage.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Insecure literal "DES" present but not used in crypto call
        String notUsedForCrypto = "DES";
        System.out.println("This is just a string: " + notUsedForCrypto); // Used elsewhere, not for Cipher.getInstance
    }
}