// Non-block statement not part of if/else or non-do loop body should not be flagged.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Group assignments in a block but keep them logically separate
        int a = 10;
        {
            a = 20;
            System.out.println(a);
        }
        label: a = 30;
        synchronized (NegCase2_Var5.class) {
            a = 40;
        }
    }
}