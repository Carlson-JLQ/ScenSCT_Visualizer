// Non-block body with no following statement in same block should not be flagged.
package scensct.var.neg;

public class NegCase3_Var1 {
    private static boolean getFlag() {
        return true;
    }
    
    public static void main(String[] args) {
        boolean flag = getFlag();
        if (flag)
            System.out.println("Flag is true");
    }
}