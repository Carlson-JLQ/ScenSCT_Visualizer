// Dereference of a non-field variable where value comes from a phi node after merge should not be flagged as always null.
package scensct.var.neg;

public class NegCase3_Var4 {
    private static Object getNonNull(boolean flag) {
        return flag ? new Object() : "test";
    }

    public static void main(String[] args) {
        Object local = getNonNull(args.length > 0);
        // Value comes from method returning non-null on both paths
        System.out.println(local.toString());
    }
}