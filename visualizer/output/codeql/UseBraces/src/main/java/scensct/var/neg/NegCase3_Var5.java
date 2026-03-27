// Non-block body with no following statement in same block should not be flagged.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 1; i++) {
            if (flag)
                System.out.println("Flag is true");
        }
    }
}