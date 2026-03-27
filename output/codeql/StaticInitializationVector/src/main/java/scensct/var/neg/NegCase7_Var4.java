// A program where a static byte array creation is not the data flow source node should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Aliasing through a wrapper object.
        class Holder {
            byte[] content;
        }
        Holder h = new Holder();
        h.content = new byte[] {0, 1}; // static creation assigned to field
        byte[] src = h.content;        // source is field read
        System.out.println(src.length);
    }
}