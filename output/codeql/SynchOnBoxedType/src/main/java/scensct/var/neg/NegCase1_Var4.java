// Synchronizing on a custom reference type should not be flagged as using a boxed primitive or String lock.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Custom reference type as a record (Java 16+)
    static record CustomLock(int id) {}

    public static void main(String[] args) {
        // Using a conditional to choose the lock, but both branches are CustomLock
        CustomLock lock = args.length > 0 ? new CustomLock(1) : new CustomLock(2);
        synchronized (lock) {
            System.out.println("Synchronized on custom reference type (record)");
        }
    }
}