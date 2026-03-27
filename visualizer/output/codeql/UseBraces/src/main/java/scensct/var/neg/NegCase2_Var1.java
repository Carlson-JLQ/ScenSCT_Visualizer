// Non-block statement not part of if/else or non-do loop body should not be flagged.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce temporaries and reorder
        int a = 10;
        int tmp = a + 10; // unrelated computation
        a = tmp;          // a = 20
        System.out.println(a);
        synchronized (NegCase2_Var1.class) {
            a = 40;
        }
        // labeled statement moved after synchronized block
        outer: a = 30;
    }
}