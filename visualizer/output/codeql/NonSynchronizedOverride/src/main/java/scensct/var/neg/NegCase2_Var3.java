// A method that overrides a non-synchronized method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase2_Var3 {
    static class Super {
        public void sup() {} // Non-synchronized
    }
    
    static class Middle extends Super {
        // No override, just inherits
    }
    
    static class Sub extends Middle {
        @Override
        public void sup() {
            // Introduce a temporary variable and loop
            for (int i = 0; i < 1; i++) {
                String output = "Override non-synchronized";
                System.out.println(output);
            }
        }
    }
}