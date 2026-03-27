// Using arithmetic addition operator should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        int val1 = 3;
        int val2 = 7;
        // Variant 4: Use array elements to obscure direct variable usage
        int[] arr = {val1, val2};
        int sum = arr[0] + arr[1];
        int diff = arr[0] - arr[1];
        int prod = arr[0] * arr[1];
        int quot = arr[0] / arr[1];
        int and = arr[0] & arr[1];
        int or = arr[0] | arr[1];
        int xor = arr[0] ^ arr[1];
        arr[0] = arr[1]; // Assignment via array
    }
}