// Calling contains on a generic collection with a compatible argument type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.Collection;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Declare as Collection, assign ArrayList
        Collection<Number> coll = new ArrayList<>();
        coll.add(10);
        coll.add(3.14);
        
        // Use autoboxing directly
        boolean exists = coll.contains(5);
        System.out.println(exists);
    }
}