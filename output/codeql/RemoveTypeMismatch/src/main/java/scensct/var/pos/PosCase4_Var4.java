// Call removeLastOccurrence on a java.util.Deque with an argument of a type that is incompatible with the deque's element type should be flagged as a violation.
package scensct.var.pos;

import java.util.Deque;
import java.util.LinkedList;

public class PosCase4_Var4 {
    // Variant 4: Use generic method to "hide" the deque, but type incompatibility remains
    private static <T> void addAndRemove(Deque<T> deque, T elementToAdd, Object objectToRemove) {
        deque.add(elementToAdd);
        // The call is still on Deque<T> with T=Character, but argument is Object (Float)
        // The static type of objectToRemove is Object, but runtime type is Float.
        // The checker should still detect incompatibility because the formal parameter type of removeLastOccurrence is Object,
        // but the element type is Character, and Float is not assignable to Character.
        deque.removeLastOccurrence(objectToRemove); // Should report
    }

    public static void main(String[] args) {
        Deque<Character> deque = new LinkedList<>();
        addAndRemove(deque, 'Z', Float.parseFloat("5.0"));
    }
}