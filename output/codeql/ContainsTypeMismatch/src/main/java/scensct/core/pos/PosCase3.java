// Call lastIndexOf on a List<Double> with an argument of type Character should be flagged as incompatible type.
package scensct.core.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase3 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        // Scenario: lastIndexOf called with Character on List<Double>
        list.lastIndexOf('c'); // [REPORTED LINE]
    }
}