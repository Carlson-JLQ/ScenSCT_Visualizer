// A try statement with catch clauses where a general checked exception precedes a specific one should be flagged as unreachable.
package scensct.core.pos;

public class PosCase1 {
    // Custom exception hierarchy to avoid compilation error
    static class GeneralException extends Exception {}
    static class SpecificException extends GeneralException {}

    public static void main(String[] args) {
        try {
            // This can throw SpecificException, a subtype of GeneralException
            throw new SpecificException();
        } catch (GeneralException e) {
            // General catch clause for GeneralException, catches SpecificException and all others
        }
        // Separate try block to demonstrate the unreachable catch pattern without compilation error
        try {
            throw new SpecificException();
        } catch (SpecificException e) {
            // Specific catch clause for SpecificException
        } catch (GeneralException e) { // [REPORTED LINE]
            // General catch clause for GeneralException, now unreachable because SpecificException already caught it
            // The checker should flag this as unreachable.
        }
    }
}