// Array access with unbounded index should be flagged as potential out-of-bounds.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        int[] data = new int[5];
        int idx = 10;
        int alias = idx; // Introduce an alias
        int result = data[alias]; // Access via alias // [REPORTED LINE]
    }
}