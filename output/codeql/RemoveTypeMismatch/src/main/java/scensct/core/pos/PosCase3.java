// Call removeFirstOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.core.pos;

import java.util.ArrayDeque;
import java.util.Deque;

public class PosCase3 {
    public static void main(String[] args) {
        Deque<Boolean> deque = new ArrayDeque<>();
        deque.add(true);
        // Incompatible argument type Long for Deque<Boolean>.removeFirstOccurrence
        deque.removeFirstOccurrence(Long.valueOf(42L)); // [REPORTED LINE]
    }
}