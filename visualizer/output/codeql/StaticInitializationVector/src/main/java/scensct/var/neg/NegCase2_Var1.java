// A program with source nodes that are not array creation expressions should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename variable, use final, and change print method.
        final String data = "not an array";
        System.err.println(data);
    }
}