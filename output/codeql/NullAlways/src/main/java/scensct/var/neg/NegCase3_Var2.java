// Dereference of a non-field variable where value comes from a phi node after merge should not be flagged as always null.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        Object result;
        boolean condition = args.length > 0;
        if (condition) {
            result = new StringBuilder("hello");
        } else {
            result = new StringBuffer("world");
        }
        // Merge point: result is definitely non-null
        System.out.println(result.toString());
    }
}