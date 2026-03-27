// A constructor call for a class other than StringBuffer or StringBuilder, with any arguments, should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - wrap in a loop and use temporary
        for (int idx = 0; idx < 1; idx++) {
            Integer temp = new Integer(40 + 2);
            OtherClass obj = new OtherClass(Character.forDigit(10, 16)); // 'a' via method
        }
    }
    
    static class OtherClass {
        OtherClass(char c) {
            // Still not a StringBuffer/StringBuilder
        }
    }
}