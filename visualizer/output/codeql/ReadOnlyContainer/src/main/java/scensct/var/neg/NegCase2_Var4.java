// A container-typed variable that is a method parameter should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;
import java.util.ArrayList;
import java.util.stream.Stream;

public class NegCase2_Var4 {
    // Variant 4: Use Stream API to query, and split logic into two separate query operations.
    public void process(Collection<String> param) {
        long count = param.stream().count();
        boolean isEmpty = (count == 0);
        System.out.println(isEmpty);
        
        // Additional read-only query: check if any element starts with "A"
        boolean anyStartsWithA = param.stream().anyMatch(s -> s.startsWith("A"));
        System.out.println("Any starts with A? " + anyStartsWithA);
    }
    
    public void another() {
        // Simplify: no catch, just a dummy method.
        System.out.println("Another method");
    }
}