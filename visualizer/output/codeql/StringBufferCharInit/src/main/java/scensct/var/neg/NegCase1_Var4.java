// A constructor call for StringBuffer or StringBuilder where the first argument is not of type char should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Control flow and aliasing
    public static void main(String[] args) {
        StringBuilder sb1;
        if (args.length >= 0) { // always true, but adds CFG edge
            sb1 = new StringBuilder(100);
        } else {
            sb1 = new StringBuilder(0);
        }
        
        String init = "initial";
        StringBuffer sb2 = new StringBuffer(init);
        
        // No-arg inside a block
        {
            StringBuilder sb3 = new StringBuilder();
        }
    }
}