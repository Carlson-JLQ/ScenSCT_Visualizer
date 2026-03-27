// Local variable assigned null dereferenced in block where first dereference is of different variable should be flagged.
package scensct.core.pos;

public class PosCase4 {
    public void test() {
        String local = null;   // Explicit null assignment
        String other = "test";
        // Block start
        {
            System.out.println(local.length()); // Moved to be first dereference in block
            System.out.println(other.length());
        }
    }
}