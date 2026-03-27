// Call search on a Stack<Short> with an argument of type Boolean should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Stack;

public class PosCase6_Var4 {
    public static void main(String[] args) {
        Stack<Short> stack = new Stack<>();
        // Using a Boolean variable from a ternary that always yields true
        Boolean b = (args.length == 0) ? Boolean.TRUE : Boolean.TRUE;
        stack.search(b); // [REPORTED LINE]
    }
}