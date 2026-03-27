// Nullness flow from a different variable to dereference should not be flagged as potential null pointer dereference for V.
package scensct.var.neg;

public class NegCase2_Var5 {
    // Variant 5: Instance method with field, but same nullness flow
    private String v;
    
    public void run() {
        v = "non-null";
        String other = null;
        // field v is non-null, other nullness irrelevant
        System.out.println(v.length());
    }
    
    public static void main(String[] args) {
        new NegCase2_Var5().run();
    }
}