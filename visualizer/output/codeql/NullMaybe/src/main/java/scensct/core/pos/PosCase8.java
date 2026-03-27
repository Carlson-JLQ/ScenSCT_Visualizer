// Guard suggests variable may be null, then later dereference in block where not first dereference of that variable should be flagged.
package scensct.core.pos;

public class PosCase8 {
    public void test(String local) {
        if (local == null) {   // Guard suggests may be null
            return;
        }
        // Block start
        {
            System.out.println(local.length()); // First dereference of 'local' in block
            System.out.println(local.hashCode()); // Not first dereference of 'local' in block
        }
    }
}