// Dereference of a non-field variable where the SSA definition in the basic block is not the source definition should not be flagged as always null.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        Object obj = null;
        boolean hasArgs = args.length > 0;
        if (!hasArgs) {
            // do nothing, keep null
        } else {
            obj = new Object();
        }
        Object target = obj;
        System.out.println(target.toString());
    }
}