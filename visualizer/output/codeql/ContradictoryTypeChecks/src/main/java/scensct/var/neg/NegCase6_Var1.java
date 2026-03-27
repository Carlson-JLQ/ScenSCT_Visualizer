// Variable checked via instanceof for SUP, SSA definition exists but no variable access reads it for cast should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        Object obj = "test";
        // Introduce a temporary alias before the instanceof
        Object alias = obj;
        if (alias instanceof CharSequence) {
            // SSA definition exists for alias inside block, but not used for cast
            System.out.println("CharSequence");
        }
        // Cast uses original obj, not alias's refined SSA definition
        StringBuilder sb = (StringBuilder) obj;
    }
}