// A local collection variable used in return statements and query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.core.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase5 {
    public List<String> getList() {
        List<String> myList = new ArrayList<>(); // Fresh container instance // [REPORTED LINE]
        int sz = myList.size();                  // Query method call
        return myList;                           // Return statement access
        // No add operations
    }
}