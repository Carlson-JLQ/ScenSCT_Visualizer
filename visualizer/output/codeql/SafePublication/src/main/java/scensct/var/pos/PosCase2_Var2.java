// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, initialized with a non-thread-safe value, and has some assignment should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;
import java.util.LinkedList;

@ThreadSafe
public class PosCase2_Var2 {
    // Changed to LinkedList, still non-thread-safe type
    private List<String> items = new LinkedList<>(); // [REPORTED LINE]

    public void insert(String value) {
        // Unsafe publication through assignment
        if (value != null) {
            items.add(value);
        }
    }
}