// A program with source nodes that are not array creation expressions should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Control-flow restructuring - wrap in if-else that always takes the true branch.
        boolean flag = true;
        String source;
        if (flag) {
            source = "not an array";
        } else {
            source = "unreachable";
        }
        System.out.println(source);
    }
}