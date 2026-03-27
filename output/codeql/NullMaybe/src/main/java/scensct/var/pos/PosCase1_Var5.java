// Field assigned null then dereferenced without null check should be flagged as potential NPE.
package scensct.var.pos;

public class PosCase1_Var5 {
    private String field;

    public void test() {
        field = null;
        try {
            System.out.println(field.length()); // [REPORTED LINE]
        } catch (RuntimeException e) {
            throw e;
        }
    }
}