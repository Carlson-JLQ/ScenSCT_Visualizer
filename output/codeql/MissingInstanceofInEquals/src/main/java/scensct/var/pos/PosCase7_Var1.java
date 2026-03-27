// equals method uses class expression involving parameter without proper type test should be flagged as bug.
package scensct.var.pos;

public class PosCase7_Var1 {
    @Override
    public boolean equals(Object other) { // [REPORTED LINE]
        // Rename parameter, keep same pattern
        return PosCase7_Var1.class == other;
    }
}