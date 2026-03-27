// equals method without type test returns equality between field and literal should be flagged as bug.
package scensct.var.pos;

public class PosCase1_Var2 {
    private int value;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Control-flow restructuring: early return with condition
        if (this.value != 42) {
            return false;
        }
        return true;
    }
}