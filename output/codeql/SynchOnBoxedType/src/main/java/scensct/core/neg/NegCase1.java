// Synchronizing on a custom reference type should not be flagged as using a boxed primitive or String lock.
package scensct.core.neg;

public class NegCase1 {
    // Custom reference type as lock object
    static class CustomLock {
        private int id;
        CustomLock(int id) { this.id = id; }
    }

    public static void main(String[] args) {
        CustomLock lock = new CustomLock(1);
        synchronized (lock) { // Lock expression type is CustomLock, not boxed primitive or String
            System.out.println("Synchronized on custom reference type");
        }
    }
}