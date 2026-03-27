// An expression that may evaluate to null is used as the selector expression in a switch expression, and the switch expression does not have a case null label should be flagged as null dereference.
package scensct.ref.pos;

public class PosCase7_FN1 {
    public static void main(String[] args) {
        String str = getNullableString();
        // Scenario: switch expression with nullable selector, no case null
        int result = switch (str) { // should trigger report
            case "A" -> 1;
            case "B" -> 2;
            default -> 3;
        };
        System.out.println(result);
    }
    
    static String getNullableString() {
        return Math.random() > 0.5 ? "A" : null;
    }
}