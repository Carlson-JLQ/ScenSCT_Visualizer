// Calling contains on a generic collection with a compatible argument type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<Number>();
        list.add(10);
        list.add(3.14);
        
        // Wrap the call in a trivial if-else that always takes the same branch
        if (System.currentTimeMillis() > 0) {
            // Argument via static method
            boolean result = list.contains(Integer.valueOf(5));
            System.out.println(result);
        } else {
            // Dead code, never executed
            System.out.println("unreachable");
        }
    }
}