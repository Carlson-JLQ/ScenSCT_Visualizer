// Dereference of a non-field variable where the SSA definition in the basic block is not the source definition should not be flagged as always null.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        Object local = null;
        try {
            if (args.length > 0) {
                local = new Object();
            }
        } catch (Exception e) {
            // local stays null
        }
        System.out.println(local.toString());
    }
}