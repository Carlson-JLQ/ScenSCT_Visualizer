// A constructor calls an instance method, but that method is either abstract or declared in a subclass (not a superclass or the same class) should not be flagged as unsafe initialization.
package scensct.var.neg;

public abstract class NegCase2_Var3 {
    protected NegCase2_Var3(boolean dummy) {
        // Alternate constructor still calls abstract method
        abstractMethod();
    }
    
    public NegCase2_Var3() {
        this(true);
    }
    
    abstract void abstractMethod();
    
    static class SubClass extends NegCase2_Var3 {
        @Override
        void abstractMethod() {
            System.out.println("Implemented in subclass");
        }
        
        public SubClass() {
            super();
            // Subclass method called after super constructor
            performAction();
        }
        
        void performAction() {
            System.out.println("Method in subclass");
        }
    }
}