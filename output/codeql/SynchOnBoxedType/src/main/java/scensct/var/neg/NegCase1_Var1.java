// Synchronizing on a custom reference type should not be flagged as using a boxed primitive or String lock.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Custom reference type as lock object - now an inner instance class
    class CustomLock {
        private final int id;
        CustomLock(int id) { this.id = id; }
    }

    public static void main(String[] args) {
        NegCase1_Var1 outer = new NegCase1_Var1();
        CustomLock lock = outer.new CustomLock(1);
        // Using a temporary variable to hold the lock before synchronization
        final Object syncTarget = lock;
        synchronized (syncTarget) {
            System.out.println("Synchronized on custom reference type via alias");
        }
    }
}