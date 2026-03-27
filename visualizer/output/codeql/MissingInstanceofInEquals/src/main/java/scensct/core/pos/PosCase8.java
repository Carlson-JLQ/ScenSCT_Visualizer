// equals method performs checked cast on parameter without preceding type test should be flagged as bug.
package scensct.core.pos;

public class PosCase8 {
    @Override
    public boolean equals(Object obj) { // [REPORTED LINE]
        // No type test, performs checked cast on parameter
        PosCase8 other = (PosCase8) obj; // Checked cast without instanceof or other test
        return true;
    }
}