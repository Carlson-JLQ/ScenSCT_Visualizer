// Non-block body with successor on same column/line and indentation not increased should not be flagged.
package scensct.var.neg;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural restructuring - split condition, use temporary in body
        int count = 2;
        boolean condition = count > 0;
        while (condition) {
            // This block is only for setup; the actual loop body is non-block
            int dummy = 0; // dummy statement, not part of the invariant
        }
        while (count > 0)
            --count; // body same column
        System.out.println("Done"); // successor same column
    }
}