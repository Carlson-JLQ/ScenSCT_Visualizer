// Synchronizing on a custom reference type should not be flagged as using a boxed primitive or String lock.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Custom reference type with a static factory method
    static class CustomLock {
        private int id;
        private CustomLock(int id) { this.id = id; }
        public static CustomLock of(int id) {
            return new CustomLock(id);
        }
    }

    public static void main(String[] args) {
        // Lock created via factory, synchronized in a try-catch block
        CustomLock lock = CustomLock.of(1);
        try {
            synchronized (lock) {
                System.out.println("Synchronized on custom reference type inside try");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done");
        }
    }
}