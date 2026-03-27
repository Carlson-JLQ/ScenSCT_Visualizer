// += operator with non-numeric destination type should not be flagged as implicit narrowing cast.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        String s = "Hello";
        s += " World"; // Scenario 2: Destination is String (non-numeric)
        System.out.println(s);
        
        boolean b = true;
        // b += false; // This would not compile for boolean, so using String is sufficient
    }
}