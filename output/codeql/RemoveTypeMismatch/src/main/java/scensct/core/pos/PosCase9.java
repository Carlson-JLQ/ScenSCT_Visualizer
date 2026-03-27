// A call to a specific java.util container removal method where the argument type at the target index is different from the receiver's element type at that index should be flagged as a violation.
package scensct.core.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase9 {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(5);
        // Incompatible argument type String for List<Number>.remove at index
        list.remove("notAnIndex"); // [REPORTED LINE]
    }
}