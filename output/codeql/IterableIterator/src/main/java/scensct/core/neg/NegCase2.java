// An abstract class that implements Iterable but does not declare a method named "iterator" should not be flagged.
package scensct.core.neg;

import java.util.Iterator;

public abstract class NegCase2 implements Iterable<String> {
    // Abstract class implements Iterable but does not declare iterator() method.
    // Since it's abstract and lacks the method declaration, the checker should not report.
    public abstract void otherMethod();
}