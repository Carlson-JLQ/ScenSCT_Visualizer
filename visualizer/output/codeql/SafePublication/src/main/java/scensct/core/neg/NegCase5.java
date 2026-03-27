// A class annotated with @ThreadSafe contains a field whose declared type is a known thread-safe type should not be flagged as unsafe publication.
package scensct.core.neg;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class NegCase5 {
    private AtomicInteger safeAtomic; // Declared type is thread-safe.
    private ConcurrentHashMap<String, String> safeMap; // Declared type is thread-safe.
}