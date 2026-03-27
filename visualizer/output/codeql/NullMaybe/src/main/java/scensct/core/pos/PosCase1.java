// Field assigned null then dereferenced without null check should be flagged as potential NPE.
package scensct.core.pos;

public class PosCase1 {
    private String field;

    public void test() {
        field = null;          // Explicit null assignment
        System.out.println(field.length()); // Dereference without null check // [REPORTED LINE]
    }
}