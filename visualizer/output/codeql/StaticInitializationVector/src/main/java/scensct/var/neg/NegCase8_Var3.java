// A program where a zero-length byte array flows to a return statement should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase8_Var3 {
    // Variant 3: Control-flow restructuring with conditional (always false)
    public static byte[] getEmptyArray() {
        byte[] empty;
        if (System.currentTimeMillis() < 0) { // never true
            empty = new byte[]{1, 2};
        } else {
            empty = new byte[0];
        }
        return empty;
    }
    public static void main(String[] args) {
        byte[] r = getEmptyArray();
        System.out.println(r.length);
    }
}