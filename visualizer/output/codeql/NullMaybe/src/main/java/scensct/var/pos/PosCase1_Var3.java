// Field assigned null then dereferenced without null check should be flagged as potential NPE.
package scensct.var.pos;

public class PosCase1_Var3 {
    private String field;

    public void test() {
        if (System.currentTimeMillis() > 0) {
            field = null;
        } else {
            return;
        }
        // field is null on the only feasible path
        System.out.println(field.length()); // [REPORTED LINE]
    }
}