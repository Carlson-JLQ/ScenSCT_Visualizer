// Unbraced then branch with same-line further indented successor should be flagged as positive.
package scensct.core.pos;

public class PosCase5 {
    public static void main(String[] args) {
        boolean condition = true;
        if (condition)
            System.out.println("Then branch"); // Unbraced then branch // [REPORTED LINE]
            System.out.println("Misleading successor"); // Same line, indented further than branch
    }
}