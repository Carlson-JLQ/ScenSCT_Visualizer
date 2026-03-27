// Local variable assigned null then first dereference in block without false null guard should be flagged.
package scensct.core.pos;

public class PosCase2 {
    public void test() {
        String local = null;   // Explicit null assignment
        // Block start
        {
            System.out.println(local.length()); // First dereference in block, no guard
        }
    }
}