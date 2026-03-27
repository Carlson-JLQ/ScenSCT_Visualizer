// equals method uses class expression involving parameter without proper type test should be flagged as bug.
package scensct.var.pos;

public class PosCase7_Var4 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // Extract comparison to helper method
        return sameClass(obj);
    }

    private boolean sameClass(Object o) {
        return PosCase7_Var4.class == o;
    }
}