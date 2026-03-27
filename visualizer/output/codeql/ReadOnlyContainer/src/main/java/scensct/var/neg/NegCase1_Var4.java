// A variable whose type is not a Collection or Map should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;

public class NegCase1_Var4 {
    // Variant 4: using wrapper types and method references, still non-container
    public void test() {
        Integer primitiveVar = Integer.valueOf(5);
        System.out.println(primitiveVar.intValue());
        
        CharSequence stringVar = "test";
        System.out.println(stringVar.length());
    }
}