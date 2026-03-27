// Variable checked via instanceof for SUP, SSA definition exists but no variable access reads it for cast should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase6_Var4 {
    public static void main(String[] args) {
        Object obj = "test";
        // Use try-catch to separate the instanceof block
        try {
            if (obj instanceof CharSequence) {
                System.out.println("CharSequence");
                throw new RuntimeException("dummy");
            }
        } catch (RuntimeException e) {
            // ignore
        }
        // Cast after try-catch, still using original obj
        StringBuilder sb = (StringBuilder) obj;
    }
}