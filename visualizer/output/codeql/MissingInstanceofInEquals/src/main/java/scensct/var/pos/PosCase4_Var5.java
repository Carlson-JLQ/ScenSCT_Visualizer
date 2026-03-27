// equals method without type test returns equality between two fields (not parameter) should be flagged as bug.
package scensct.var.pos;

public class PosCase4_Var5 {
    private int a = 1;
    private int b = 2;

    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Extract comparison to a private helper
        return fieldsEqual();
    }

    private boolean fieldsEqual() {
        return a == b;
    }
}