// Calling hashCode() on an array should be flagged as comparing object identity.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Idiomatic variation - using a different array type (String array)
        String[] strArr = {"a", "b", "c"};
        int hash = strArr.hashCode(); // [REPORTED LINE]
        System.out.println(hash);
    }
}