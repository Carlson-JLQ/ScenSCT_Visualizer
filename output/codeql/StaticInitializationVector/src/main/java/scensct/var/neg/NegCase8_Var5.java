// A program where a zero-length byte array flows to a return statement should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase8_Var5 {
    // Variant 5: Inter-procedural: split creation and return across helpers
    private static byte[] createEmpty() {
        return new byte[0];
    }
    public static byte[] getEmptyArray() {
        byte[] e = createEmpty();
        return e;
    }
    public static void main(String[] args) {
        byte[] val = getEmptyArray();
        System.out.println(val.length);
    }
}