// Call removeLastOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Deque;
import java.util.LinkedList;

public class PosCase4_Var2 {
    // Variant 2: Extract call into a private static helper method
    private static void removeFromDeque(Deque<Character> d, Float flt) {
        d.removeLastOccurrence(flt); // Should report // [REPORTED LINE]
    }

    public static void main(String[] args) {
        Deque<Character> deque = new LinkedList<>();
        deque.push('C');
        removeFromDeque(deque, new Float(3.14f));
    }
}