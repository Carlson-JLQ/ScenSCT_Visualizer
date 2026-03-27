// A string literal matching the insecure pattern is present but never used as algorithm parameter in any cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

import java.util.List;
import java.util.Arrays;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Store the literal in a list and retrieve it
        List<String> strings = Arrays.asList("AES", "DES", "RSA");
        String notUsedForCrypto = strings.get(1); // "DES"
        System.out.println("This is just a string: " + notUsedForCrypto);
    }
}