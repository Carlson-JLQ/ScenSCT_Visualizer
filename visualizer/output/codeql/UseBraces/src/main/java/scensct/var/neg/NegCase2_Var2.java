// Non-block statement not part of if/else or non-do loop body should not be flagged.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Extract some logic into a helper method
        int a = initAndPrint();
        synchronized (NegCase2_Var2.class) {
            a = 40;
        }
        label: a = 30;
    }
    
    private static int initAndPrint() {
        int x = 10;
        x = 20;
        System.out.println(x);
        return x;
    }
}