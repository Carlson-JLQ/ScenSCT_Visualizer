// Unbraced then branch with same-line further indented successor should be flagged as positive.
package scensct.var.pos;

public class PosCase5_Var5 {
    public static void main(String[] args) {
        boolean condition = true;
        Object obj = condition ? "yes" : "no";
        for (int i = 0; i < 1; i++) {
            if (condition)
                System.out.println("Then branch"); // [REPORTED LINE]
                System.out.println("Misleading successor"); // Indented within loop but not part of branch
        }
    }
}