// If condition inside loop with constant false comparison and increment compared to itself, then branch not a throw.
package scensct.var.pos;

public class PosCase4_Var4 {
    public static void main(String[] args) {
        // Variant 4: while loop with temporary alias, using !=
        int idx = 0;
        while (idx < 10) {
            int a = idx;
            int b = --idx;
            if (b != a - 1) { // b = idx-1, a = old idx? Wait, careful: after --idx, idx is decremented. // [REPORTED LINE]
                // Actually: int a = idx; int b = --idx; means a takes original idx, then idx decremented, b = new idx.
                // So b = idx-1 (original idx-1), a = original idx.
                // Then b != a-1? b = original idx-1, a-1 = original idx-1, so they are equal. Condition always false.
                System.out.println("Unreachable");
            }
            idx = a + 1; // restore and increment
        }
    }
}