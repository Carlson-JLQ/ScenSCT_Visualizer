// Assignment to a field with same field name but different qualifiers should not be flagged as self-assignment.
package scensct.core.neg;

public class NegCase3 {
    static class Holder {
        int value;
    }
    public static void main(String[] args) {
        Holder obj1 = new Holder();
        Holder obj2 = new Holder();
        obj1.value = obj2.value; // Same field name 'value', but qualifiers 'obj1' and 'obj2' are different objects
    }
}