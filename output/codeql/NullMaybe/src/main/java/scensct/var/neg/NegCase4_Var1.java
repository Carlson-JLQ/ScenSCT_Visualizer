// Nullness flow from V to dereference exists but not due to guard, null argument, or direct null assignment should not be flagged.
package scensct.var.neg;

public class NegCase4_Var1 {
    static String fetchString(boolean condition) {
        if (condition) {
            return "non-null";
        } else {
            return null;
        }
    }
    
    public static void main(String[] args) {
        String data = fetchString(true);
        // Same witness: data is non-null here
        System.out.println(data.length());
    }
}