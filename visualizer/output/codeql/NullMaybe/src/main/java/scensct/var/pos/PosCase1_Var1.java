// Field assigned null then dereferenced without null check should be flagged as potential NPE.
package scensct.var.pos;

public class PosCase1_Var1 {
    private String field;

    public void test() {
        field = getNull();
        String local = field;
        System.out.println(local.length());
    }

    private String getNull() {
        return null;
    }
}