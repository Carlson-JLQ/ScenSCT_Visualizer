// A container-typed local variable with only assignment, return, and query accesses should be flagged as uninitialized container.
package scensct.core.pos;

import java.util.LinkedList;
import java.util.Queue;

public class PosCase6 {
    public Queue<Double> process() {
        Queue<Double> queue = new LinkedList<>(); // Fresh assignment
        boolean empty = queue.isEmpty();          // Query method call (at least one)
        // Remove return statement to ensure only read-only queries are used
        // Keep query usage but no return or other accesses
        int size = queue.size();                  // Additional query method call
        // No mutation after creation
        return null;                              // Return something else to keep compilation
    }
}