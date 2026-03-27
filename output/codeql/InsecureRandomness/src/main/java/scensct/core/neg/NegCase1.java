// No insecure randomness source should not be flagged as insecure randomness usage.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // No insecure randomness source present.
        int x = 10;
        System.out.println(x);
    }
}