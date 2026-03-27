// Call removeFirstOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayDeque;
import java.util.Deque;

public class PosCase3_Var5 {
    public static void main(String[] args) {
        Deque<Boolean> d = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            d.add(i % 2 == 0);
        }
        // Incompatible removal via autoboxed Long
        long primitive = 42L;
        d.removeFirstOccurrence(primitive); // [REPORTED LINE]
    }
}