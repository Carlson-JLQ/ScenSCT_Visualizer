// Dereference of a non-field variable where the SSA definition in the basic block is not the source definition should not be flagged as always null.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        Object local = null; // Ultimate definition is null
        if (args.length > 0) {
            local = new Object(); // New SSA definition in this block
        }
        // Dereference uses the definition from the if block, not the source null definition
        System.out.println(local.toString());
    }
}