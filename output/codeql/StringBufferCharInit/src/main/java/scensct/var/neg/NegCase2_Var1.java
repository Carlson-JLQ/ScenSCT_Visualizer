// A constructor call for a class other than StringBuffer or StringBuilder, with any arguments, should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - use char variable and explicit cast
        char ch = 'a';
        int num = 42;
        Integer i = new Integer(num);
        OtherClass oc = new OtherClass((char) ch);
    }
    
    static class OtherClass {
        OtherClass(char c) {
            // Char argument is fine here
        }
    }
}