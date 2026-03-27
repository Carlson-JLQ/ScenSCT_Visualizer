// Synchronizing on a custom reference type should not be flagged as using a boxed primitive or String lock.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Custom reference type implementing an interface
    static interface Lockable {}
    static class CustomLock implements Lockable {
        private int id;
        CustomLock(int id) { this.id = id; }
    }

    static CustomLock createLock(int id) {
        return new CustomLock(id);
    }

    static void performSynchronizedTask(Object lock) {
        synchronized (lock) {
            System.out.println("Synchronized on custom reference type passed as Object");
        }
    }

    public static void main(String[] args) {
        CustomLock lock = createLock(1);
        performSynchronizedTask(lock);
    }
}