// Dereference of a non-field variable where value comes from a phi node after merge should not be flagged as always null.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        Object target = null;
        // Restructure: use a temporary to hold the non-null value before assignment
        if (args.length > 0) {
            Object temp = new Object();
            target = temp;
        } else {
            target = "test";
        }
        // After merge, target is non-null
        System.out.println(target.getClass());
    }
}