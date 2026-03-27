// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, the field is written by exactly one callable (a constructor), and that writing constructor does not call the original superclass constructor should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase7_Var1 {
    protected String data; // Changed type and name
    
    public NegCase7_Var1() {
        // Call overridden method
        invokeOverride();
    }
    
    void invokeOverride() { // Renamed method
        System.out.println("Base method");
    }
}

class SubClass7 extends NegCase7_Var1 {
    public SubClass7() {
        // No explicit super call
        // Write field after implicit super()
        data = "initialized"; // Only write
    }
    
    @Override
    void invokeOverride() {
        // Read field
        String value = data;
        System.out.println("Data: " + value);
    }
}