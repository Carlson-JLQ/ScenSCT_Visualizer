// A variable whose type is not a Collection or Map should not be flagged as an uninitialized container.
package scensct.var.neg;

import java.util.Collection;

public class NegCase1_Var3 {
    // Variant 3: inter-procedural extraction
    private void printInt(int value) {
        System.out.println(value);
    }
    
    private void printStringLength(String s) {
        System.out.println(s.length());
    }
    
    public void test() {
        int primitiveVar = 5;
        printInt(primitiveVar);
        
        String stringVar = "test";
        printStringLength(stringVar);
    }
}