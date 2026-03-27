// A variable whose type is not a Collection or Map should not be flagged as an uninitialized container.
package scensct.core.neg;

import java.util.Collection;

public class NegCase1 {
    public void test() {
        // Scenario 1: primitive type, not a container
        int primitiveVar = 5;
        System.out.println(primitiveVar);
        
        // Scenario 1: simple object type, not a container
        String stringVar = "test";
        System.out.println(stringVar.length());
    }
}