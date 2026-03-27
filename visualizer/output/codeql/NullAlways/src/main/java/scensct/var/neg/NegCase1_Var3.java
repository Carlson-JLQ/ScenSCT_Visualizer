// Dereference of a non-field variable where the SSA definition in the basic block is not the source definition should not be flagged as always null.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        Object local = getObject(args);
        System.out.println(local.toString());
    }

    private static Object getObject(String[] args) {
        if (args.length > 0) {
            return new Object();
        }
        return null;
    }
}