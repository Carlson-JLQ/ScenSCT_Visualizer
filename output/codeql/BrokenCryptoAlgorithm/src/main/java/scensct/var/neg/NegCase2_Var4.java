// A string literal matching the insecure pattern is present but never used as algorithm parameter in any cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Use StringBuilder to construct the literal
        StringBuilder sb = new StringBuilder();
        sb.append('D');
        sb.append('E');
        sb.append('S');
        String notUsedForCrypto = sb.toString();
        // Loop that prints multiple times but no crypto
        for (int i = 0; i < 2; i++) {
            System.out.println("Iteration " + i + ": " + notUsedForCrypto);
        }
    }
}