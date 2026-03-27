// A constructor call for StringBuffer or StringBuilder where the first argument is not of type char should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Use expressions and temporaries
    public static void main(String[] args) {
        int capacity = 50 * 2;
        StringBuilder sb1 = new StringBuilder(capacity);
        
        String prefix = "init";
        String suffix = "ial";
        StringBuffer sb2 = new StringBuffer(prefix + suffix);
        
        // Unchanged no-arg
        StringBuilder sb3 = new StringBuilder();
    }
}