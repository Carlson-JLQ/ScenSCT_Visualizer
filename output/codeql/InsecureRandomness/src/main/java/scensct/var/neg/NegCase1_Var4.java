// No insecure randomness source should not be flagged as insecure randomness usage.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Introducing a method that processes data, but still no insecure random source.
        int[] values = {10, 20, 30};
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        int average = sum / values.length;
        System.out.println(average);
    }
}