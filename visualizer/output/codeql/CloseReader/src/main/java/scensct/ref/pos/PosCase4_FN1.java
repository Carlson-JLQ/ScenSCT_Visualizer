// Wrapper BufferedReader around parameter InputStream not closed should be flagged.
package scensct.ref.pos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PosCase4_FN1 {
    public void wrapParameter(InputStream paramStream) {
        new BufferedReader(new InputStreamReader(paramStream)); // Wrapper around parameter, not assigned or closed
    }
}