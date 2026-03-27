// A constructor does not call any non-private, non-final instance method (or calls a method with a qualifier that is not `this` or an explicit superclass type) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase1_Var3 {
    private int value;
    
    public NegCase1_Var3() {
        // Extract safe call sequence into a private instance method (still safe)
        performSafeOperations();
    }
    
    private void performSafeOperations() {
        privateHelper();
        staticHelper();
        NegCase1_Var3 other = new NegCase1_Var3();
        other.instanceMethod();
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