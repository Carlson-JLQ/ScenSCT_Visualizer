// A variable whose type is not a Collection or Map should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;

public class NegCase1_Var5 {
    // Variant 5: try-catch block and reassignment, preserving non-container type
    public void test() {
        int primitiveVar;
        try {
            primitiveVar = 5;
        } catch (Exception e) {
            primitiveVar = -1;
        }
        System.out.println(primitiveVar);
        
        String stringVar = "test".toUpperCase();
        System.out.println(stringVar.length());
    }
}