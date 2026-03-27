// Assignment to a field with same field name but different qualifiers should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase3_Var1 {
    static class Holder {
        int value;
    }
    public static void main(String[] args) {
        Holder obj1 = new Holder();
        Holder obj2 = new Holder();
        // Variant 1: Introduce an alias for obj2, but still distinct from obj1
        Holder alias = obj2;
        obj1.value = alias.value;
    }
}