// A constructor call for a class other than StringBuffer or StringBuilder, with any arguments, should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Inter-procedural refactoring - delegate construction to helper methods
        createInteger();
        createOtherClass();
    }
    
    private static void createInteger() {
        Integer i = new Integer(42);
    }
    
    private static void createOtherClass() {
        OtherClass oc = new OtherClass('a');
    }
    
    static class OtherClass {
        OtherClass(char c) {
            // Char constructor remains unchanged
        }
    }
}