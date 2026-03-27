// A constructor calls a non-abstract, non-final instance method declared in a superclass, but that method is not overridden by any method in any superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase3_Var4 {
    public NegCase3_Var4() {
        // Method call inside a conditional that always executes
        if (true) {
            methodInSuperclass();
        }
    }
    
    void methodInSuperclass() {
        System.out.println("Method in superclass, not overridden");
    }
}

class SubClass3 extends NegCase3_Var4 {
    // No override
}