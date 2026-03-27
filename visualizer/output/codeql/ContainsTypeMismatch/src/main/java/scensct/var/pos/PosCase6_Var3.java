// Call search on a Stack<Short> with an argument of type Boolean should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Stack;

public class PosCase6_Var3 {
    public static void main(String[] args) {
        Stack<Short> stack = new Stack<>();
        helper(stack);
    }
    
    private static void helper(Stack<Short> st) {
        // Extracted call preserves the mismatch
        st.search(Boolean.valueOf(true)); // [REPORTED LINE]
    }
}