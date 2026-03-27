// Non-block statement not part of if/else or non-do loop body should not be flagged.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use try-finally around synchronized, keep same statements
        int a = 10;
        a = 20;
        System.out.println(a);
        try {
            synchronized (NegCase2_Var3.class) {
                a = 40;
            }
        } finally {
            // empty finally, just for structure
        }
        label: a = 30;
    }
}