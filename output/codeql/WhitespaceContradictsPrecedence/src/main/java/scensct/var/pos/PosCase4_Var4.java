// Scenario 4: Binary operator with more whitespace around inner operator, satisfying both exclusion sets, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase4_Var4 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("1");
            int b = Integer.parseInt("2");
            int c = Integer.parseInt("3");
            int result = a ^ b   & c; // Wrapped in try-catch but expression unchanged // [REPORTED LINE]
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}