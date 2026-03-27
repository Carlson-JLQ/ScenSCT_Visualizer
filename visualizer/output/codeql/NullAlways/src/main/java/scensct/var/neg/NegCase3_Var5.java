// Dereference of a non-field variable where value comes from a phi node after merge should not be flagged as always null.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        Object local;
        try {
            if (args.length > 0) {
                local = new Object();
            } else {
                local = "test";
            }
        } finally {
            // Finally block does not alter the non-null guarantee
            System.out.print("Merge point: ");
        }
        // Dereference after try-finally, local still non-null
        System.out.println(local.toString());
    }
}