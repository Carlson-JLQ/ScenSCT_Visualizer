// equals method without type test returns equality between two fields (not parameter) should be flagged as bug.
package scensct.var.pos;

public class PosCase4_Var2 {
    private int a = 1;
    private int b = 2;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Introduce a temporary variable
        boolean result = (a == b);
        return result;
    }
}