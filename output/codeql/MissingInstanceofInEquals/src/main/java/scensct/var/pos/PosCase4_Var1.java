// equals method without type test returns equality between two fields (not parameter) should be flagged as bug.
package scensct.var.pos;

public class PosCase4_Var1 {
    private int x = 1;
    private int y = 2;

    @Override
    public boolean equals(Object other) { // [REPORTED LINE]
        // Renamed fields and parameter, same logic
        return x == y;
    }
}