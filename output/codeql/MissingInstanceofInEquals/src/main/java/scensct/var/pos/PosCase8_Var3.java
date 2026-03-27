// equals method performs checked cast on parameter without preceding type test should be flagged as bug.
package scensct.var.pos;

public class PosCase8_Var3 {
    // Helper method that performs the cast without type test
    private PosCase8_Var3 uncheckedCast(Object o) {
        return (PosCase8_Var3) o;
    }

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Variant 3: Extract cast to a helper method, still no instanceof
        PosCase8_Var3 other = uncheckedCast(obj);
        return other != null;
    }
}