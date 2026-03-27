// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.var.pos;

public class PosCase1_Var3 {
    static class Superclass {
        Superclass() {
            init();
        }
        
        final void init() {
            // Final method calls the overridable one
            doInitialize();
        }
        
        void doInitialize() {
            // Base
        }
    }
    
    static class Subclass extends Superclass {
        private int value;
        
        Subclass() {
            super();
            value = 42;
        }
        
        @Override
        void doInitialize() {
            // Read in a loop (control‑flow variation)
            for (int i = 0; i < 1; i++) {
                System.out.println(value);
            }
        }
    }
    
    public static void main(String[] args) {
        new Subclass();
    }
}