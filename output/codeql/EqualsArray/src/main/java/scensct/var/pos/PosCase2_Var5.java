// Calling equals(Object) on an array with compatible array argument should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        Object[] objs1 = new Object[]{"test"};
        Object[] objs2 = new Object[]{"test"};
        // Using try-catch-finally to structure the call
        try {
            boolean eq = objs1.equals(objs2); // [REPORTED LINE]
            System.out.println(eq);
        } catch (Exception e) {
            // ignore
        } finally {
            System.out.println("Done");
        }
    }
}