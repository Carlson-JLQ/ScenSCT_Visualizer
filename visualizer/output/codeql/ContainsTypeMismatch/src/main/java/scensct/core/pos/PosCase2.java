// Call indexOf on a List<String> with an argument of type Integer should be flagged as incompatible type.
package scensct.core.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Scenario: indexOf called with Integer on List<String>
        list.indexOf(123); // [REPORTED LINE]
    }
}