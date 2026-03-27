// A class annotated with @ThreadSafe contains a field whose initializer expression is a known thread-safe type should not be flagged as unsafe publication.
package scensct.core.neg;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class NegCase6 {
    private Object safeField = new AtomicInteger(); // Initializer is a thread-safe type instance.
    private ConcurrentHashMap<?, ?> anotherSafe = new ConcurrentHashMap<>(); // Initializer is a thread-safe type instance.
}