// Synchronizing on a custom reference type should not be flagged as using a boxed primitive or String lock.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Custom reference type with a generic wrapper
    static class Box<T> {
        private final T value;
        Box(T value) { this.value = value; }
        T get() { return value; }
    }

    static class CustomLock {
        private int id;
        CustomLock(int id) { this.id = id; }
    }

    public static void main(String[] args) {
        Box<CustomLock> box = new Box<>(new CustomLock(1));
        CustomLock lock = box.get();
        // Synchronization after a loop that does not affect the lock
        for (int i = 0; i < 1; i++) {
            // empty loop to add control flow
        }
        synchronized (lock) {
            System.out.println("Synchronized on custom reference type unwrapped from generic");
        }
    }
}