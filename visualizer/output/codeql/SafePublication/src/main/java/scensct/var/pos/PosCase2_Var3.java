// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, initialized with a non-thread-safe value, and has some assignment should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;

@ThreadSafe
public class PosCase2_Var3 {
    // Field declared without initialization
    private ArrayList<String> list; // [REPORTED LINE]

    // Constructor performs unsafe initialization (non-final field)
    public PosCase2_Var3() {
        list = new ArrayList<>();
    }

    public void addItem(String item) {
        // Additional assignment
        list.add(item);
    }
}