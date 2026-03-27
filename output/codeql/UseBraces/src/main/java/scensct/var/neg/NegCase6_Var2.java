// Non-block body that is a jump/return/throw statement should not be flagged despite misleading indentation.
package scensct.var.neg;

public class NegCase6_Var2 {
    private static boolean isLarge(int val) {
        return val > 10;
    }
    
    private static void fail(String msg) {
        throw new RuntimeException(msg);
    }
    
    public static void main(String[] args) {
        int x = 5;
        if (isLarge(x))
            return;
        else
            fail("Too small");
        // Unreachable
    }
}