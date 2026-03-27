// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, initialized with a non-thread-safe value, and has some assignment should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;

@ThreadSafe
public class PosCase2_Var1 {
    // Renamed field, same unsafe characteristics
    private ArrayList<String> dataStore = new ArrayList<>(); // [REPORTED LINE]

    public void append(String element) {
        // Assignment via method call - unsafe
        dataStore.add(element);
    }
}