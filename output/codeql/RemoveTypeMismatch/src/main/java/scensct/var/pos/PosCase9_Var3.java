// A call to a specific java.util container removal method where the argument type at the target index is different from the receiver's element type at that index should be flagged as a violation.
package scensct.var.pos;

import java.util.List;
import java.util.ArrayList;

public class PosCase9_Var3 {
    public static void main(String[] args) {
        List<Number> container = new ArrayList<>();
        container.add(5);
        // Introduce aliasing via a raw type (still List<Number> at runtime)
        List rawList = container;
        rawList.remove("notAnIndex");
    }
}