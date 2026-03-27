// A class annotated with @ThreadSafe contains a field that is declared final, static, or volatile should not be flagged as unsafe publication.
package scensct.core.neg;

@ThreadSafe
public class NegCase3 {
    private final Object finalField = new Object(); // Final field is safely published.
    private static Object staticField; // Static field is safely published.
    private volatile Object volatileField; // Volatile field is safely published.
}