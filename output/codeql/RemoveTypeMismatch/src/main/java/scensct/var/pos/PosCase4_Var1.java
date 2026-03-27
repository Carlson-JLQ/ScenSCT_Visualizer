// Call removeLastOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Different Deque implementation and argument via variable
        Deque<Character> charDeque = new ArrayDeque<>();
        charDeque.offer('B');
        Float fArg = Float.valueOf(2.5f);
        charDeque.removeLastOccurrence(fArg); // Should report // [REPORTED LINE]
    }
}