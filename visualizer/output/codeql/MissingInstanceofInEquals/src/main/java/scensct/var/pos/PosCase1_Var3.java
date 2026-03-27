// equals method without type test returns equality between field and literal should be flagged as bug.
package scensct.var.pos;

public class PosCase1_Var3 {
    private int value;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Inter-procedural refactoring: delegate comparison to helper method
        return checkEquality(this.value);
    }

    private boolean checkEquality(int val) {
        return val == 42;
    }
}