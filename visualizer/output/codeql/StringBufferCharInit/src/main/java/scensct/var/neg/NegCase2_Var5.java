// A constructor call for a class other than StringBuffer or StringBuilder, with any arguments, should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Control-flow restructuring with conditional and try-catch
        try {
            Integer i = new Integer(args.length > 0 ? Integer.parseInt(args[0]) : 42);
            OtherClass oc = new OtherClass(getChar());
        } catch (Exception e) {
            // Ignore
        }
    }
    
    private static char getChar() {
        return 'a';
    }
    
    static class OtherClass {
        OtherClass(char c) {
            // Char argument is intentional
        }
    }
}