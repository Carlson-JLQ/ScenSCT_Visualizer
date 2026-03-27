// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, initialized with a non-thread-safe value, and has some assignment should be flagged as unsafe publication.
package scensct.core.pos;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class PosCase2 {
    // Non-final, non-static, non-volatile field with non-thread-safe type (ArrayList)
    private java.util.ArrayList<String> list = new java.util.ArrayList<>(); // Initialized with non-thread-safe value // [REPORTED LINE]

    public void addItem(String item) {
        // Additional assignment - unsafe publication
        list.add(item);
    }
}