// Creating a java.util.ArrayList should not be flagged as a resource leak.
package scensct.core.neg;

import java.util.ArrayList;

public class NegCase1 {
    public void test() {
        // Scenario 1: Type is not Reader/InputStream/ZipFile or a closeable ancestor.
        new ArrayList<String>(); // No resource leak expected.
    }
}