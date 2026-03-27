// Calling equals or hashCode on non-array types should not be flagged as array equals/hashCode misuse.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Control-Flow Restructuring & Aliasing
    // Use a loop to repeat calls, introduce an alias via assignment, and wrap in try-finally.
    public static void main(String[] args) {
        String str = "loopTest";
        Object obj = null;
        for (int i = 0; i < 1; i++) {
            str.equals("loopTest");
            obj = str; // alias, still non-array type
            obj.hashCode();
        }
        
        obj = new Object();
        try {
            obj.equals(str);
        } finally {
            obj.hashCode();
        }
    }
}