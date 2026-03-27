// Variable checked via instanceof for SUP, SSA definition exists but no variable access reads it for cast should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static void main(String[] args) {
        Object obj = "test";
        // Extract instanceof check to a helper method that does not return refined type
        if (isCharSequence(obj)) {
            System.out.println("CharSequence");
        }
        // Cast unchanged
        StringBuilder sb = (StringBuilder) obj;
    }

    private static boolean isCharSequence(Object o) {
        return o instanceof CharSequence;
    }
}