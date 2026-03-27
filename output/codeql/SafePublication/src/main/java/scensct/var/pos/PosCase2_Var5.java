// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, initialized with a non-thread-safe value, and has some assignment should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;

@ThreadSafe
public class PosCase2_Var5 {
    // Field wrapped in try-catch during initialization (still unsafe)
    private ArrayList<String> list;

    {
        try {
            list = new ArrayList<>();
        } catch (Exception e) {
            list = new ArrayList<>();
        }
    }

    public void addItem(String item) {
        // Assignment with control flow
        synchronized (this) {
            // Synchronized block does not make field publication-safe
        }
        list.add(item);
    }
}