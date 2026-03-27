// A local collection variable used in return statements and query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase5_Var4 {
    public List<String> getList() {
        List<String> myList = new ArrayList<>();
        try {
            // query in try block
            boolean empty = myList.isEmpty();
        } catch (Exception e) {
            // ignore, no mutation
        } finally {
            // still no mutation
        }
        return myList;
    }
}