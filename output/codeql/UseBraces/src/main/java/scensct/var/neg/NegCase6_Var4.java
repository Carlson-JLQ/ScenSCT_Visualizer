// Non-block body that is a jump/return/throw statement should not be flagged despite misleading indentation.
package scensct.var.neg;

public class NegCase6_Var4 {
    public static void main(String[] args) {
        int x = 5;
        try {
            if (x > 10)
                return;
            else
                throw new RuntimeException("Too small");
        } finally {
            // Cleanup logic – doesn't affect jump detection
        }
        // Misleading indentation after finally
    }
}