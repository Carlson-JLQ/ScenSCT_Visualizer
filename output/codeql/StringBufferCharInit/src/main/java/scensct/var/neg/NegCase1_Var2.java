// A constructor call for StringBuffer or StringBuilder where the first argument is not of type char should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Inter-procedural extraction
    public static void main(String[] args) {
        buildWithInt(100);
        buildWithString("initial");
        new StringBuilder(); // direct call
    }
    
    private static void buildWithInt(int cap) {
        StringBuilder sb = new StringBuilder(cap);
    }
    
    private static void buildWithString(String text) {
        StringBuffer sb = new StringBuffer(text);
    }
}