// Call search on a Stack<Short> with an argument of type Boolean should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Stack;

public class PosCase6_Var2 {
    public static void main(String[] args) {
        Stack<Short> s = new Stack<>();
        if (args.length >= 0) { // always true
            s.search(Boolean.TRUE); // [REPORTED LINE]
        }
    }
}