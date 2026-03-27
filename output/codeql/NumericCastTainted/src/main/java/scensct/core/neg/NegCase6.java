// Narrowing cast of a variable tainted from user source but confined to small type earlier should not be flagged.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        // Scenario 6: Value confined via earlier cast preventing overflow.
        int userInput = Integer.parseInt("300"); // User source.
        short confined = (short) userInput; // Earlier narrowing cast to short.
        byte b = (byte) confined; // Cast of confined variable.
        System.out.println(b);
    }
}