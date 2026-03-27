// Field assigned null then dereferenced without null check should be flagged as potential NPE.
package scensct.var.pos;

public class PosCase1_Var2 {
    private String field;

    public void test() {
        field = null;
        for (int i = 0; i < 1; i++) {
            System.out.println(field.length()); // [REPORTED LINE]
        }
    }
}