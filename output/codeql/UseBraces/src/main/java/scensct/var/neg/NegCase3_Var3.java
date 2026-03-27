// Non-block body with no following statement in same block should not be flagged.
package scensct.var.neg;

public class NegCase3_Var3 {
    private static void checkFlag(boolean flag) {
        if (flag)
            System.out.println("Flag is true");
    }
    
    public static void main(String[] args) {
        boolean flag = true;
        checkFlag(flag);
    }
}