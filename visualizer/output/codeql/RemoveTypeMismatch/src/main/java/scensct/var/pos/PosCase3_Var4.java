// Call removeFirstOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayDeque;
import java.util.Deque;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        Deque<Boolean> deque = new ArrayDeque<>();
        if (args.length > 0) {
            deque.add(true);
        } else {
            deque.add(false);
        }
        // The call is always reachable, argument type still Long
        Long arg = Long.parseLong("42");
        deque.removeFirstOccurrence(arg); // [REPORTED LINE]
    }
}