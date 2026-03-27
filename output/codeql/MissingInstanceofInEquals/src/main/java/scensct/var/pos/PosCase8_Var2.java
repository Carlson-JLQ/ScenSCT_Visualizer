// equals method performs checked cast on parameter without preceding type test should be flagged as bug.
package scensct.var.pos;

public class PosCase8_Var2 {
    @Override
    public boolean equals(Object obj) {
        // Variant 2: Wrap cast in a try-catch block, still no type test
        try {
            PosCase8_Var2 other = (PosCase8_Var2) obj;
            return true;
        } catch (ClassCastException e) {
            // Swallow exception, but cast is still attempted without guard
            return false;
        }
    }
}