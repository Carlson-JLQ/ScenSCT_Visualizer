// Calling List.add should not be flagged as incompatible removal method.
package scensct.core.neg;

import java.util.ArrayList;
import java.util.List;

public class NegCase1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Scenario 1: add is not a removal method, so no report.
        list.add("item");
    }
}