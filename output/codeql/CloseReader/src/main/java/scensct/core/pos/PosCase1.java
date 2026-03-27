// FileInputStream created but not closed should be flagged as resource leak.
package scensct.core.pos;

import java.io.FileInputStream;
import java.io.IOException;

public class PosCase1 {
    public void readFile() throws IOException {
        new FileInputStream("test.txt"); // Direct instantiation without assignment or close // [REPORTED LINE]
    }
}