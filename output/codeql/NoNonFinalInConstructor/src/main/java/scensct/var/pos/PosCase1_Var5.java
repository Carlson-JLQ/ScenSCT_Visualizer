// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.var.pos;

public class PosCase1_Var5 {
    static class Superclass {
        Superclass() {
            // Call after a no‑effect statement
            Object o = new Object();
            initialize();
        }
        
        void initialize() {
            // Base
        }
    }
    
    static class Subclass extends Superclass {
        private int value;
        
        Subclass() {
            super();
            // Write moved to an instance initializer block? No, keep in constructor.
            assign();
        }
        
        private void assign() {
            value = 42;
        }
        
        @Override
        void initialize() {
            // Read in a try‑catch (control‑flow noise)
            try {
                System.out.println(value);
            } catch (Exception e) {
                // ignore
            }
        }
    }
    
    public static void main(String[] args) {
        new Subclass();
    }
}