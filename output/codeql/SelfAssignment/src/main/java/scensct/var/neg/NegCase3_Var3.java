// Assignment to a field with same field name but different qualifiers should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase3_Var3 {
    static class Holder {
        int value;
    }
    static void copyValue(Holder dest, Holder src) {
        dest.value = src.value; // distinct qualifiers preserved via parameters
    }
    public static void main(String[] args) {
        Holder obj1 = new Holder();
        Holder obj2 = new Holder();
        // Variant 3: Move assignment into a helper method
        copyValue(obj1, obj2);
    }
}