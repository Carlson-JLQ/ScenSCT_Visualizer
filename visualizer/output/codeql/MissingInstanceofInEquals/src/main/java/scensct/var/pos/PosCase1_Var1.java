// equals method without type test returns equality between field and literal should be flagged as bug.
package scensct.var.pos;

public class PosCase1_Var1 {
    private int value;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Lexical refactoring: rename parameter, use temporary variable for literal
        int target = 42;
        boolean result = this.value == target;
        return result;
    }
}