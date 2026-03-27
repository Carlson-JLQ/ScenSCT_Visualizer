// Assignment between different variables should not be flagged as self-assignment.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        a = b; // Destination 'a' and source 'b' refer to different variables
    }
}