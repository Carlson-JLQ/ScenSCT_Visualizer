// Call removeLastOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Deque;
import java.util.LinkedList;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: Inline Float creation, use different literal, rename everything
        Deque<Character> q = new LinkedList<>();
        q.offerLast('1');
        // Direct call with valueOf using a different static factory style
        q.removeLastOccurrence(Float.valueOf(42F)); // Should report // [REPORTED LINE]
    }
}