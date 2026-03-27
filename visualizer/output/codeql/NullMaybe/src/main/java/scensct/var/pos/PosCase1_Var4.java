// Field assigned null then dereferenced without null check should be flagged as potential NPE.
package scensct.var.pos;

public class PosCase1_Var4 {
    private String field;

    public void test() {
        assignNull();
        dereference();
    }

    private void assignNull() {
        field = null;
    }

    private void dereference() {
        System.out.println(field.length());
    }
}