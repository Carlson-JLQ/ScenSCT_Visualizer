// Non-block body with no following statement in same block should not be flagged.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        boolean flag = true;
        try {
            if (flag)
                System.out.println("Flag is true");
        } finally {
            // Cleanup after the if, but not part of the same block
        }
    }
}