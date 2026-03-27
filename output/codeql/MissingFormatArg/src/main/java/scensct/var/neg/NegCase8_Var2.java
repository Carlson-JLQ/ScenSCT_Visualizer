// A recognized format method call with known format specifiers but undetermined argument count should not be flagged.
package scensct.var.neg;

public class NegCase8_Var2 {
    static Object[] getArgs() {
        return new Object[]{"world"};
    }
    static void printGreeting() {
        // Variant 2: Call moved to a static helper method
        String message = String.format("Hello %s", getArgs());
        System.out.println(message);
    }
    public static void main(String[] args) {
        printGreeting();
    }
}