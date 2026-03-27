// Call removeLastOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Deque;
import java.util.LinkedList;

public class PosCase4_Var3 {
    public static void main(String[] args) {
        // Variant 3: Introduce trivial control flow and temporary
        Deque<Character> d = new LinkedList<>();
        d.add('X');
        d.add('Y');
        Object obj = Float.valueOf(-0.0f);
        if (true) { // always true, but adds a basic block
            d.removeLastOccurrence((Float) obj); // Should report // [REPORTED LINE]
        }
    }
}