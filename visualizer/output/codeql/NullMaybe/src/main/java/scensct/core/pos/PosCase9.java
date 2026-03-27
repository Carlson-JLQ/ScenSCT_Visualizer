// Guard suggests variable may be null, then dereferenced in block where first dereference is of different variable should be flagged.
package scensct.core.pos;

public class PosCase9 {
    public void test(String local) {
        if (local == null) {   // Guard suggests may be null
            return;
        }
        String other = "test";
        // Block start
        {
            System.out.println(local.length()); // Moved to be first dereference in block
            System.out.println(other.length());
        }
    }
}