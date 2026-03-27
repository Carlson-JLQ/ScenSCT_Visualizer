// Synchronizing on a boxed primitive type (Integer) should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var5 {
    // Variant 5: lock obtained via explicit cast from Number, with nested block
    public static void main(String[] args) {
        Number num = Integer.valueOf(1);
        Integer lock = (Integer) num;
        {
            synchronized (lock) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        }
    }
}