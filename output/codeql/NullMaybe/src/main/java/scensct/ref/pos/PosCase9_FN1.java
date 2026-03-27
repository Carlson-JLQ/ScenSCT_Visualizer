// Guard suggests variable may be null, then dereferenced in block where first dereference is of different variable should be flagged.
package scensct.ref.pos;

public class PosCase9_FN1 {
    public void test(String local) {
        if (local == null) {   // Guard suggests may be null
            return;
        }
        String other = "test";
        // Block start
        {
            System.out.println(other.length()); // First dereference in block (different variable)
            System.out.println(local.length()); // Dereference of 'local' after first dereference
        }
    }
}