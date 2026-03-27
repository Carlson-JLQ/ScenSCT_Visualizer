// Variable checked via instanceof for SUP, SSA definition exists but no variable access reads it for cast should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        Object obj = "test";
        // Restructure control flow with a labeled break
        outer: {
            if (obj instanceof CharSequence) {
                System.out.println("CharSequence");
                break outer;
            }
            // If not CharSequence, do something else (never reached here)
            System.out.println("Not CharSequence");
        }
        // Cast after the block, still using original obj
        StringBuilder sb = (StringBuilder) obj;
    }
}