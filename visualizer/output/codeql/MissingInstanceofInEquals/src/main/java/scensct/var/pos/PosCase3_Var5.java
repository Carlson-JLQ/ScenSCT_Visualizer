// equals method without type test returns equality between two literals should be flagged as bug.
package scensct.var.pos;

public class PosCase3_Var5 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        try {
            // Literal comparison inside try block, no type test
            return "abc".length() == 3;
        } finally {
            // empty finally doesn't affect bug
        }
    }
}