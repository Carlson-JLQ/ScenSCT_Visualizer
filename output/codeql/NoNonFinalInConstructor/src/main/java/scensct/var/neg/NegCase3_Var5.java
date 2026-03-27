// A constructor calls a non-abstract, non-final instance method declared in a superclass, but that method is not overridden by any method in any superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase3_Var5 {
    public NegCase3_Var5() {
        // Call extracted to a static helper that takes instance parameter
        Helper.callMethod(this);
    }
    
    void methodInSuperclass() {
        System.out.println("Method in superclass, not overridden");
    }
    
    private static class Helper {
        static void callMethod(NegCase3_Var5 instance) {
            instance.methodInSuperclass();
        }
    }
}

class SubClass3 extends NegCase3_Var5 {
    // No override
}