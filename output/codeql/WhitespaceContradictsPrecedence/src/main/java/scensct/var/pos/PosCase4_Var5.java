// Scenario 4: Binary operator with more whitespace around inner operator, satisfying both exclusion sets, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        
        if (args.length > 0) {
            // Expression placed inside conditional branch
            int result = a ^ b   & c; // [REPORTED LINE]
            System.out.println("Result: " + result);
        } else {
            System.out.println("No args");
        }
    }
}