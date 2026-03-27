// A constructor does not call any non-private, non-final instance method (or calls a method with a qualifier that is not `this` or an explicit superclass type) should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase1_Var2 {
    private int value;
    
    public NegCase1_Var2() {
        // Safe calls wrapped in a conditional block
        if (true) {
            privateHelper();
        }
        // Instance method on a separate object created via a factory method
        NegCase1_Var2 other = createOther();
        other.instanceMethod();
        staticHelper();
    }
    
    private NegCase1_Var2 createOther() {
        return new NegCase1_Var2();
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