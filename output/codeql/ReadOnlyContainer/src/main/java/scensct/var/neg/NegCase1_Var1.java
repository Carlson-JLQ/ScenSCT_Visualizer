// A variable whose type is not a Collection or Map should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;

public class NegCase1_Var1 {
    public void test() {
        // Variant 1: lexical refactoring + different non-container types
        int primitiveVar = Integer.parseInt("5");
        System.out.println(primitiveVar);
        
        Object stringVar = "test";
        System.out.println(((String) stringVar).length());
    }
}