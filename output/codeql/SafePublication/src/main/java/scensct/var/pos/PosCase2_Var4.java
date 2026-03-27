// A non-final/static/volatile field with a non-thread-safe declared type in a @ThreadSafe class, initialized with a non-thread-safe value, and has some assignment should be flagged as unsafe publication.
package scensct.var.pos;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;

@ThreadSafe
public class PosCase2_Var4 {
    // Field initialized via helper method
    private ArrayList<String> list = initList(); // [REPORTED LINE]

    private static ArrayList<String> initList() {
        return new ArrayList<>();
    }

    public void addItem(String item) {
        // Assignment extracted to helper
        addToList(item);
    }

    private void addToList(String s) {
        list.add(s);
    }
}