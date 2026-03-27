// A constructor calls a non-abstract, non-final instance method declared in a superclass, and that method is overridden in a superclass, but the overriding method does not read any non-final field declared in a superclass should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase4_Var5 {
    protected int field;
    
    public NegCase4_Var5() {
        for (int i = 0; i < 1; i++) {
            doWork();
        }
    }
    
    void doWork() {
        System.out.println("Original method");
    }
    
    static NegCase4_Var5 identity(NegCase4_Var5 obj) {
        return obj;
    }
}

class SubClass4 extends NegCase4_Var5 {
    @Override
    void doWork() {
        int local = 42; // unrelated to 'field'
        System.out.println("Overridden method, no field read, local=" + local);
    }
}