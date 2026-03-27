// An expression that may evaluate to null is used as the selector expression in a switch statement, and the switch statement does not have a case null label should be flagged as null dereference.
package scensct.ref.pos;

public class PosCase8_FN1 {
    public static void main(String[] args) {
        String str = getNullableString();
        // Scenario: switch statement with nullable selector, no case null
        switch (str) { // should trigger report
            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;
            default:
                System.out.println("other");
        }
    }
    
    static String getNullableString() {
        return Math.random() > 0.5 ? "A" : null;
    }
}