// Array access with unbounded index should be flagged as potential out-of-bounds.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        int[] arr = createArray();
        int index = getIndex();
        int value = arr[index]; // Access with index from method
    }

    private static int[] createArray() {
        return new int[5];
    }

    private static int getIndex() {
        return 10;
    }
}