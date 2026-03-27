// Call removeFirstOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class PosCase3_Var3 {
    public static void main(String[] args) {
        Deque<Boolean> deque = new LinkedBlockingDeque<>();
        deque.offer(Boolean.TRUE);
        // Using Long constructor directly
        deque.removeFirstOccurrence(new Long(42)); // [REPORTED LINE]
    }
}