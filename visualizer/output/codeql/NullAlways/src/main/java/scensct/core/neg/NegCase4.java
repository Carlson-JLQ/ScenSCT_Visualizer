// Dereference of a non-field variable whose ultimate definition is not always null should not be flagged as always null.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        Object local = new Object(); // Ultimate definition is non-null
        System.out.println(local.toString());
    }
}