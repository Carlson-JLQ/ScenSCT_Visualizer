// A constructor does not call any non-private, non-final instance method (or calls a method with a qualifier that is not `this` or an explicit superclass type) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase1_Var5 {
    private int value;
    
    public NegCase1_Var5() {
        // Safe calls inside a try-catch-finally block
        try {
            privateHelper();
        } finally {
            staticHelper();
        }
        // Instance method on an object from an array
        NegCase1_Var5[] others = { new NegCase1_Var5() };
        others[0].instanceMethod();
    }
    
    private void privateHelper() {
        System.out.println("Private helper");
    }
    
    private static void staticHelper() {
        System.out.println("Static helper");
    }
    
    public void instanceMethod() {
        System.out.println("Instance method");
    }
}