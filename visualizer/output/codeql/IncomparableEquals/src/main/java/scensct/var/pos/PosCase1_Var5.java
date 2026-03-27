// Top-level call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var5 {
    // Variant 5: Different incomparable types (Collection types)
    public static void main(String[] args) {
        java.util.List<String> list = new java.util.ArrayList<>();
        java.util.Set<Integer> set = new java.util.HashSet<>();
        boolean result = list.equals(set); // List vs Set, incomparable // [REPORTED LINE]
    }
}