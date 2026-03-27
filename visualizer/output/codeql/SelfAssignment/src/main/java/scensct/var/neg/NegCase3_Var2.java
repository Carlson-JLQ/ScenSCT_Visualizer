// Assignment to a field with same field name but different qualifiers should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase3_Var2 {
    static class Holder {
        int value;
    }
    public static void main(String[] args) {
        Holder obj1 = new Holder();
        Holder obj2 = new Holder();
        // Variant 2: Use a conditional branch that doesn't affect distinctness
        if (args.length > 0) {
            obj1.value = obj2.value;
        } else {
            obj1.value = obj2.value; // same in both branches
        }
    }
}