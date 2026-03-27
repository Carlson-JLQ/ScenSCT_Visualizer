// A constructor calls a non-abstract, non-final instance method declared in a superclass, but that method is not overridden by any method in any superclass should not be flagged as unsafe initialization.
package scensct.core.neg;

public class NegCase3 {
    public NegCase3() {
        // Calls a non-abstract, non-final method that is not overridden in any superclass.
        methodInSuperclass();
    }
    
    void methodInSuperclass() {
        System.out.println("Method in superclass, not overridden");
    }
}

// Subclass that does NOT override the method.
class SubClass3 extends NegCase3 {
    // No override of methodInSuperclass.
}