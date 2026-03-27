// A concrete class that implements Iterable and has an iterator() method with empty body should not be flagged.
package scensct.core.neg;

import java.util.Iterator;

public class NegCase4 implements Iterable<Object> {
    // Concrete class implements Iterable with iterator() method having empty body (zero statements).
    // This does not return "this", so the checker should not report.
    public Iterator<Object> iterator() {
        // Empty body: zero statements
        return null;
    }
}