// A constructor does not call any non-private, non-final instance method (or calls a method with a qualifier that is not `this` or an explicit superclass type) should not be flagged as unsafe initialization.
package scensct.core.neg;

public class NegCase1 {
    private int value;
    
    public NegCase1() {
        // Constructor calls a private method, which is safe.
        privateHelper();
        // Constructor calls a static method, which is safe.
        staticHelper();
        // Constructor calls an instance method on a different object, not `this`.
        NegCase1 other = new NegCase1();
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