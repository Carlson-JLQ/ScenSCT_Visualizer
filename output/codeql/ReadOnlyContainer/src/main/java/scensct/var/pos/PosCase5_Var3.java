// A local collection variable used in return statements and query methods with XML-referenced type should be flagged as uninitialized container.
package scensct.var.pos;

import java.util.ArrayList;
import java.util.List;

public class PosCase5_Var3 {
    private int checkSize(List<String> lst) {
        return lst.size(); // query extracted
    }

    public List<String> getList() {
        List<String> data = new ArrayList<>();
        // call extracted query method
        int sz = checkSize(data);
        return data;
    }
}