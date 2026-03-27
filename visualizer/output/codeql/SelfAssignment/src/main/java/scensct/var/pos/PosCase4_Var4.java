// Nested instance field self-assignment within the same class via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase4_Var4 {
    static class SubHolder {
        int subfield;
    }
    private SubHolder obj = new SubHolder();

    // Helper method that performs the self-assignment.
    private void assignSelf(SubHolder holder) {
        holder.subfield = holder.subfield; // [REPORTED LINE]
    }

    public void method() {
        // Variant 4: Delegate the self-assignment to a helper method.
        assignSelf(this.obj);
    }
}