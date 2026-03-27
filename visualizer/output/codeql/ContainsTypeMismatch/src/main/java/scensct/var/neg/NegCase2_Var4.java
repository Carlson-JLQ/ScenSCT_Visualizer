// Calling contains on a generic collection with a compatible argument type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Initialize list in a static block-like style inside method
        ArrayList<Number> col = new ArrayList<>();
        col.add(Integer.valueOf(10));
        col.add(Double.valueOf(3.14));
        
        // Use try-catch-finally, but no exception thrown
        try {
            Integer arg = Integer.valueOf(5);
            boolean res = col.contains(arg);
            System.out.println(res);
        } catch (RuntimeException e) {
            // Never reached
            System.out.println("error");
        } finally {
            // Cleanup not needed, just for flow variation
            System.out.println("checked");
        }
    }
}