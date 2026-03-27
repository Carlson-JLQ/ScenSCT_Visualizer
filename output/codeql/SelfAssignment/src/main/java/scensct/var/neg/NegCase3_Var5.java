// Assignment to a field with same field name but different qualifiers should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase3_Var5 {
    static class Holder {
        int value;
        Holder other;
    }
    public static void main(String[] args) {
        Holder obj1 = new Holder();
        Holder obj2 = new Holder();
        obj1.other = obj2;
        // Variant 5: Nested field access, still distinct objects
        obj1.value = obj1.other.value; // qualifiers: obj1 vs obj1.other (which is obj2)
    }
}