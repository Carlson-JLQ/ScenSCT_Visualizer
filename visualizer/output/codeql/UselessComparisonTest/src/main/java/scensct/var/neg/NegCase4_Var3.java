// Binary expression that is a redundant equality test (guarded) used within an assertion should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase4_Var3 {
    public static void main(String[] args) {
        int a = getValue();
        // Guard using switch
        switch (a) {
            case 10:
                // Assertion with explicit boolean expression
                boolean check = (a == 10);
                assert check : "check failed";
                break;
            default:
                return;
        }
    }
    private static int getValue() {
        return 10;
    }
}