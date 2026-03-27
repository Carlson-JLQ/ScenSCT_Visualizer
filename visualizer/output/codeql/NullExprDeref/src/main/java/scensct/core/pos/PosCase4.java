// An expression that may evaluate to null is used as the iterable expression in an enhanced for statement should be flagged as null dereference.
package scensct.core.pos;

import java.util.List;

public class PosCase4 {
    public static void main(String[] args) {
        List<String> list = getNullableList();
        // Scenario: enhanced for over nullable iterable
        for (String s : list) { // should trigger report
            System.out.println(s);
        }
    }
    
    static List<String> getNullableList() {
        return null;
    }
}