// equals method without type test returns equality between field and literal should be flagged as bug.
package scensct.core.pos;

public class PosCase1 {
    private int value;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // No type test, returns equality comparison: field access vs literal
        return value == 42; // Field 'value' compared to literal 42
    }
}