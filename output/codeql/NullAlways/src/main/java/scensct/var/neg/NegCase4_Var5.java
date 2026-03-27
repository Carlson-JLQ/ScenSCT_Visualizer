// Dereference of a non-field variable whose ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: Control-flow restructuring with loop, but still definite non-null
        Object local = null;
        for (int i = 0; i < 1; i++) {
            local = new Object();
            break; // ensures exactly one assignment
        }
        // local is non-null here (loop always executes and assigns)
        System.out.println(local.toString());
    }
}