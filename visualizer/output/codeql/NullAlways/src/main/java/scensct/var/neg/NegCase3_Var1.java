// Dereference of a non-field variable where value comes from a phi node after merge should not be flagged as always null.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        Object obj;
        if (args.length > 0) {
            obj = Integer.valueOf(1);
        } else {
            obj = Double.valueOf(2.0);
        }
        // Phi merge: both definitions are non-null
        System.out.println(obj.hashCode());
    }
}