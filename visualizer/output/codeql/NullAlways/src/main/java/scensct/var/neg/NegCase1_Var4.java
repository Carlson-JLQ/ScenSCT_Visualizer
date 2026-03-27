// Dereference of a non-field variable where the SSA definition in the basic block is not the source definition should not be flagged as always null.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        Object local = args.length > 0 ? new Object() : null;
        System.out.println(local.toString());
    }
}