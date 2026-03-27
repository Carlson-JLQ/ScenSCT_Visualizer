// Synchronizing on a boxed primitive type (Integer) should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var2 {
    // Variant 2: lock passed through a helper method
    private static void doSync(Integer lockObj) {
        synchronized (lockObj) { // [REPORTED LINE]
            System.out.println("Inside synchronized block");
        }
    }
    
    public static void main(String[] args) {
        Integer lock = Integer.valueOf(1);
        doSync(lock);
    }
}