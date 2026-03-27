// Synchronizing on a boxed primitive type (Integer) should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var4 {
    // Variant 4: lock variable aliased via assignment, wrapped in try-finally
    public static void main(String[] args) {
        Integer lock = Integer.valueOf(1);
        Integer alias = lock;
        try {
            synchronized (alias) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        } finally {
            System.out.println("Done");
        }
    }
}