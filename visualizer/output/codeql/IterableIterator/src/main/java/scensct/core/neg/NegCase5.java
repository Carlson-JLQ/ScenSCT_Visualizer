// A concrete class that implements Iterable and has an iterator() method returning null should not be flagged.
package scensct.core.neg;

import java.util.Iterator;

public class NegCase5 implements Iterable<String> {
    // Concrete class implements Iterable with iterator() method returning null.
    // Single statement but not return "this", so the checker should not report.
    public Iterator<String> iterator() {
        return null; // Single statement returning null
    }
}