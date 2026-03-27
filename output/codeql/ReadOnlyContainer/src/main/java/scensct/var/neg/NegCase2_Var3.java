// A container-typed variable that is a method parameter should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class NegCase2_Var3 {
    // Variant 3: Use iterator to query emptiness indirectly, and wrap in a try-catch for robustness.
    public void process(Collection<String> param) {
        try {
            Iterator<String> it = param.iterator();
            boolean hasElements = it.hasNext();
            System.out.println(!hasElements);
        } catch (NullPointerException npe) {
            System.out.println("param was null");
        }
    }
    
    public void another() {
        // Keep catch clause but with a container-like array (not a Collection).
        try {
            int[] arr = new int[5];
            System.out.println(arr.length);
        } catch (Exception e) {
            // e is not a container
        }
    }
}