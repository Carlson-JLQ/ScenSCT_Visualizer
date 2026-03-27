// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.var.pos;

public class PosCase6_Var3 {
    public static void main(String[] args) {
        final boolean cond = false;
        boolean another = false;
        if (cond) {
            output("First if");
        } else {
            if (another) { // Braced else with inner if, but outer else is braced? Wait, this changes structure.
                output("Else if");
            } else
                output("Else branch"); // Unbraced else branch inside braced else block // [REPORTED LINE]
                output("Misleading successor"); // This is misleading: actually belongs to the outer else block?
        }
        // This variant is invalid because it changes the else chain structure. Let's discard and provide a correct one.
    }

    private static void output(String s) {
        System.out.println(s);
    }
}