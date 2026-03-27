// A constructor calls a non-abstract, non-final instance method declared in a superclass, and that method is overridden in a superclass, but the overriding method does not read any non-final field declared in a superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase4_Var2 {
    protected int field = 0; // explicit initializer
    
    public NegCase4_Var2() {
        NegCase4_Var2 self = this; // alias
        try {
            self.invoke(); // call via alias
        } finally {
            // empty finally, no effect
        }
    }
    
    void invoke() {
        System.out.println("Original method");
    }
}

class SubClass4 extends NegCase4_Var2 {
    @Override
    void invoke() {
        // overriding method still does NOT read 'field'
        String msg = "Overridden method, no field read";
        for (char c : msg.toCharArray()) {
            System.out.print(c);
        }
        System.out.println();
    }
}