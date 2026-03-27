// Wrapper BufferedReader around parameter InputStream not closed should be flagged.
package scensct.core.pos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PosCase4 {
    public void wrapParameter(InputStream paramStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(paramStream)); // Wrapper assigned but not closed
    }
}