// A variable whose type is not a Collection or Map should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;

public class NegCase1_Var2 {
    public void test() {
        // Variant 2: control-flow restructuring with same non-container semantics
        int primitiveVar;
        if (System.currentTimeMillis() > 0) {
            primitiveVar = 5;
        } else {
            primitiveVar = 0;
        }
        System.out.println(primitiveVar);
        
        String stringVar = "test";
        for (int i = 0; i < 1; i++) {
            System.out.println(stringVar.length());
        }
    }
}