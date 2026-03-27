// Passing a char literal to StringBuffer constructor should be flagged as using capacity instead of character.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        // Single char argument triggers the checker
        StringBuffer buffer = new StringBuffer('a'); // [REPORTED LINE]
    }
}