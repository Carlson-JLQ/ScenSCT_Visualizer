// equals method uses class expression involving parameter without proper type test should be flagged as bug.
package scensct.var.pos;

public class PosCase7_Var3 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Negated comparison, still same pattern
        boolean notEqual = PosCase7_Var3.class != obj;
        return !notEqual;
    }
}