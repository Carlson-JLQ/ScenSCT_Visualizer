// Call search on a Stack<Short> with an argument of type Boolean should be flagged as incompatible type.
package scensct.core.pos;

import java.util.Stack;

public class PosCase6 {
    public static void main(String[] args) {
        Stack<Short> stack = new Stack<>();
        // Scenario: search called with Boolean on Stack<Short>
        stack.search(true); // [REPORTED LINE]
    }
}