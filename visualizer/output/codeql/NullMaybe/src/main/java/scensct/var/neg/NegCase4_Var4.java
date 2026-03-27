// Nullness flow from V to dereference exists but not due to guard, null argument, or direct null assignment should not be flagged.
package scensct.var.neg;

public class NegCase4_Var4 {
    static String getPossiblyNull(boolean flag) {
        return flag ? "non-null" : null;
    }
    
    public static void main(String[] args) {
        String v = getPossiblyNull(true);
        String alias = v;
        // alias remains non-null
        alias = alias.trim(); // non-null operation
        System.out.println(alias.length());
    }
}