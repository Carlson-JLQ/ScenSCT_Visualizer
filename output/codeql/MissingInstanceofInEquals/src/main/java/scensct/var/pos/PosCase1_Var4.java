// equals method without type test returns equality between field and literal should be flagged as bug.
package scensct.var.pos;

public class PosCase1_Var4 {
    private int value;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Idiomatic variation: use Objects.equals with boxed types, but still no type test
        Integer fieldVal = this.value;
        Integer literalVal = 42;
        return java.util.Objects.equals(fieldVal, literalVal);
    }
}