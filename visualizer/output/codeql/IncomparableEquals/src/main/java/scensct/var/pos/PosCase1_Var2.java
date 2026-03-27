// Top-level call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - extract call into a helper method
    private static boolean compareIncomparable(String str, Integer num) {
        return str.equals(num); // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        String s = "test";
        Integer i = 123;
        boolean result = compareIncomparable(s, i);
    }
}