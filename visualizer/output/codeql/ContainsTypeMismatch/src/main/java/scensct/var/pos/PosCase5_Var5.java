// Call lastIndexOf on a Vector<Byte> with an argument of type Float (first argument) should be flagged as incompatible type.
package scensct.var.pos;

import java.util.Vector;

public class PosCase5_Var5 {
    public static void main(String[] args) {
        Vector<? extends Byte> vec = new Vector<Byte>();
        // Wildcard capture: still Vector<Byte> compatible
        Float arg = 3.14f;
        // Raw type manipulation to obscure but preserve generic info
        Vector rawVec = vec;
        // Checker must still detect Byte vs Float incompatibility
        rawVec.lastIndexOf(arg);
    }
}