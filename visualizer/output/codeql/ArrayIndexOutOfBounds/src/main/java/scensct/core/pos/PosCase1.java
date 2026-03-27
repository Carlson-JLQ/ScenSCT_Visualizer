// Array access with unbounded index should be flagged as potential out-of-bounds.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int index = 10; // Unbounded index, no constraint check before access
        int value = arr[index]; // Direct access with potentially out-of-bounds index // [REPORTED LINE]
    }
}