// Call removeFirstOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.ArrayDeque;
import java.util.Deque;

public class PosCase3_Var2 {
    private static void attemptRemoval(Deque<Boolean> deque, Object obj) {
        // The call site is here, still with incompatible Long
        deque.removeFirstOccurrence(obj);
    }
    
    public static void main(String[] args) {
        Deque<Boolean> d = new ArrayDeque<>();
        d.add(false);
        Long value = 42L;
        attemptRemoval(d, value);
    }
}