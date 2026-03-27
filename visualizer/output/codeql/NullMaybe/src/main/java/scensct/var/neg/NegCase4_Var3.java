// Nullness flow from V to dereference exists but not due to guard, null argument, or direct null assignment should not be flagged.
package scensct.var.neg;

public class NegCase4_Var3 {
    static String getPossiblyNull(boolean flag) {
        return flag ? "non-null" : null;
    }
    
    static void printLength(String s) {
        // Checker must see s is non-null when called from main
        System.out.println(s.length());
    }
    
    public static void main(String[] args) {
        String v = getPossiblyNull(true);
        printLength(v);
    }
}