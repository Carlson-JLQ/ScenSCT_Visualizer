// Call removeLastOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.core.pos;

import java.util.Deque;
import java.util.LinkedList;

public class PosCase4 {
    public static void main(String[] args) {
        Deque<Character> deque = new LinkedList<>();
        deque.add('A');
        // Incompatible argument type Float for Deque<Character>.removeLastOccurrence
        deque.removeLastOccurrence(Float.valueOf(1.0f)); // [REPORTED LINE]
    }
}