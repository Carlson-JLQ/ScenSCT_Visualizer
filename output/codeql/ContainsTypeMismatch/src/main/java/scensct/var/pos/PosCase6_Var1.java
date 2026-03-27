// Call search on a Stack<Short> with an argument of type Boolean should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Stack;

public class PosCase6_Var1 {
    public static void main(String[] args) {
        Stack<Short> numberStack = new Stack<Short>();
        boolean flag = true;
        // Same type mismatch: Boolean vs Stack<Short>
        numberStack.search(flag); // [REPORTED LINE]
    }
}