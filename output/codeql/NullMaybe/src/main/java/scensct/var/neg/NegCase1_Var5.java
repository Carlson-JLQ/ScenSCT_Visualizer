// Variable dereferenced with provably non-null value should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Control-flow restructuring with a trivially true condition
        String s;
        if (args.length >= 0) { // always true
            s = "always assigned";
        } else {
            s = "unreachable";
        }
        System.out.println(s.length());
    }
}