// Calling contains on a generic collection with a compatible argument type should not be flagged.
package scensct.var.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Use List interface, diamond operator, and different initial values
        List<Number> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(10));
        numbers.add(Double.valueOf(3.14));
        
        // Store argument in a local variable
        Integer searchKey = 5;
        boolean found = numbers.contains(searchKey);
        System.out.println(found);
    }
}