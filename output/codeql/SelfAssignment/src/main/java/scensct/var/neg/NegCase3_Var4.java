// Assignment to a field with same field name but different qualifiers should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase3_Var4 {
    static class Holder {
        int value;
    }
    public static void main(String[] args) {
        Holder[] arr = new Holder[2];
        arr[0] = new Holder();
        arr[1] = new Holder();
        // Variant 4: Use array elements as qualifiers (different indices)
        arr[0].value = arr[1].value;
    }
}