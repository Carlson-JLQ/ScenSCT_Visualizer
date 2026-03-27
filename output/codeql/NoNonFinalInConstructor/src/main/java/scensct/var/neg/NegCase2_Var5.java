// A constructor calls an instance method, but that method is either abstract or declared in a subclass (not a superclass or the same class) should not be flagged as unsafe initialization.
package scensct.var.neg;

public abstract class NegCase2_Var5 {
    public NegCase2_Var5() {
        callAbstract();
    }
    
    abstract void abstractMethod();
    
    final void callAbstract() {
        abstractMethod(); // final delegator, still calling abstract method
    }
    
    static class SubClass extends NegCase2_Var5 {
        @Override
        void abstractMethod() {
            System.out.println("Implemented in subclass");
        }
        
        public SubClass() {
            // Subclass method invoked through an interface implemented by this class
            Worker w = new Worker() {
                public void work() {
                    subMethod();
                }
            };
            w.work();
        }
        
        void subMethod() {
            System.out.println("Method in subclass");
        }
        
        interface Worker {
            void work();
        }
    }
}