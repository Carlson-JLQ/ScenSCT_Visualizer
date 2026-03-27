// Assignment with source as literal should not be flagged as self-assignment.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int x = 5;
        x = 10; // Destination is variable 'x', source is literal 10 (not a variable access)
    }
}