// Dereference of a non-field variable where the SSA definition in the basic block is not the source definition should not be flagged as always null.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        Object local = null;
        Object temp = null;
        if (args.length > 0) {
            temp = new Object();
        }
        for (int i = 0; i < 1; i++) {
            local = temp;
        }
        System.out.println(local.toString());
    }
}