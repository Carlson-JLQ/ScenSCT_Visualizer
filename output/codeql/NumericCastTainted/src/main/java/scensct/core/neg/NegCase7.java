// Narrowing cast within hashCode method should not be flagged as numeric narrowing cast of tainted variable.
package scensct.core.neg;

public class NegCase7 {
    private int value;
    public NegCase7(int v) { value = v; }
    // Scenario 7: Cast occurs within hashCode implementation.
    @Override
    public int hashCode() {
        int userInput = value; // Assume tainted from user source via constructor.
        byte b = (byte) userInput; // Cast inside hashCode.
        return b;
    }
    public static void main(String[] args) {
        System.out.println(new NegCase7(1000).hashCode());
    }
}