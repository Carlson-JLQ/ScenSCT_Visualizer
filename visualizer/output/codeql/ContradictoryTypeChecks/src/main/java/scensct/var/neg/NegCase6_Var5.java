// Variable checked via instanceof for SUP, SSA definition exists but no variable access reads it for cast should not be flagged as contradictory type check.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        Object obj = "test";
        // Introduce a loop that runs once, with instanceof inside
        for (int i = 0; i < 1; i++) {
            if (obj instanceof CharSequence) {
                System.out.println("CharSequence");
                continue;
            }
        }
        // Cast after loop, using original obj
        StringBuilder sb = (StringBuilder) obj;
    }
}