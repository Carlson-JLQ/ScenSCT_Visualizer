// A string literal matching the insecure pattern is present but never used as algorithm parameter in any cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Split the literal into parts and concatenate
        String part1 = "D";
        String part2 = "ES";
        String notUsedForCrypto = part1 + part2;
        System.out.println("This is just a string: " + notUsedForCrypto);
    }
}