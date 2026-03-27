// A container-typed local variable with only assignment, return, and query accesses should be flagged as uninitialized container.
package scensct.ref.pos;

import java.util.LinkedList;
import java.util.Queue;

public class PosCase6_FN1 {
    public Queue<Double> process() {
        Queue<Double> queue = new LinkedList<>(); // Fresh assignment
        boolean empty = queue.isEmpty();          // Query method call (at least one)
        return queue;                             // Return statement access
        // No mutation after creation
    }
}