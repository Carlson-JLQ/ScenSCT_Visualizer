// Guard suggests variable may be null, then first dereference in block without false null guard should be flagged.
package scensct.core.pos;

public class PosCase7 {
    public void test(String local) {
        if (local == null) {   // Guard suggests may be null
            return;
        }
        // Block start
        {
            System.out.println(local.length()); // First dereference in block, no guard
        }
    }
}