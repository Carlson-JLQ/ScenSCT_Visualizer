// equals method without type test returns equality between two fields (not parameter) should be flagged as bug.
package scensct.var.pos;

public class PosCase4_Var4 {
    private int a = 1;
    private int b = 2;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Wrap in try-catch (no exception thrown)
        try {
            return a == b;
        } catch (Exception e) {
            return false;
        }
    }
}