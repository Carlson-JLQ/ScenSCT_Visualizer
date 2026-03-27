// Call search on a Stack<Short> with an argument of type Boolean should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Stack;

public class PosCase6_Var5 {
    public static void main(String[] args) {
        Stack<Short> stack = new Stack<>();
        // Wrapping in try-catch that doesn't affect reachability
        try {
            stack.search(true); // [REPORTED LINE]
        } catch (Exception e) {
            // never reached
        }
    }
}