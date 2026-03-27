// A local collection variable used in return statements and query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PosCase5_Var5 {
    public List<String> getList() {
        // using Collections.emptyList() would be immutable, but here we keep fresh mutable instance
        List<String> col = new ArrayList<>(); // [REPORTED LINE]
        // multiple query calls
        col.contains("test");
        col.size();
        // return without mutation
        return col;
    }
}