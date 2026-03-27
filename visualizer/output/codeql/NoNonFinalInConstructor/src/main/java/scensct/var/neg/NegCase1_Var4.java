// A constructor does not call any non-private, non-final instance method (or calls a method with a qualifier that is not `this` or an explicit superclass type) should not be flagged as unsafe initialization.
package scensct.var.neg;

import java.util.function.Consumer;

public class NegCase1_Var4 {
    private int value;
    
    public NegCase1_Var4() {
        // Use a lambda to invoke instance method on a distinct object
        Consumer<NegCase1_Var4> consumer = NegCase1_Var4::instanceMethod;
        consumer.accept(new NegCase1_Var4());
        privateHelper();
        staticHelper();
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