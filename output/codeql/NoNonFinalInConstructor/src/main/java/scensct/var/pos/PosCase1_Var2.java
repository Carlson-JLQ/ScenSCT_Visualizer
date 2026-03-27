// Superclass constructor calls non-abstract, non-final method; subclass overrides and reads non-final field before subclass constructor writes it should be flagged as unsafe.
package scensct.var.pos;

public class PosCase1_Var2 {
    static class Superclass {
        Superclass() {
            // Call inside a conditional that always executes
            if (true) {
                initialize();
            }
        }
        
        void initialize() {
            // Base
        }
    }
    
    static class Subclass extends Superclass {
        private int data; // Renamed field
        
        Subclass() {
            super();
            data = 100;
        }
        
        @Override
        void initialize() {
            // Indirect read via a private method
            int x = getData();
            System.out.println(x);
        }
        
        private int getData() {
            return data; // Still reading the field before initialization
        }
    }
    
    public static void main(String[] args) {
        new Subclass();
    }
}