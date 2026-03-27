// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.var.pos;

public class PosCase5_Var3 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 3: Extract the equality check into a private helper method.
        final Object local = new Object();
        return compareWithLocal(obj, local);
    }

    private boolean compareWithLocal(Object o, Object local) {
        // Helper still lacks type test.
        return o == local;
    }
}